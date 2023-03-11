package io.openpixee.java.plugins.codeql;

import com.contrastsecurity.sarif.PhysicalLocation;
import com.contrastsecurity.sarif.Result;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import io.codemodder.DependencyGAV;
import io.codemodder.Weave;
import io.openpixee.java.DoNothingVisitor;
import io.openpixee.java.FileWeavingContext;
import io.openpixee.java.VisitorFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Fixes issues reported under CodeQL's id "java/database-resource-leak" */
final class JEXLInjectionVisitorFactory implements VisitorFactory {

  /** The locations of each result. */
  private final List<PhysicalLocation> locations;

  /** The root of the repository. */
  private final String repositoryRootPath;

  JEXLInjectionVisitorFactory(final File repositoryRoot, final Set<Result> results) {
    Objects.requireNonNull(results, "results");
    this.locations =
        results.stream()
            .map(result -> result.getLocations().get(0).getPhysicalLocation())
            .collect(Collectors.toUnmodifiableList());
    try {
      this.repositoryRootPath =
          Objects.requireNonNull(repositoryRoot.getCanonicalPath(), "repositoryRootPath");
    } catch (IOException e) {
      throw new IllegalArgumentException("Bad path for " + repositoryRoot, e);
    }
  }

  @Override
  public ModifierVisitor<FileWeavingContext> createJavaCodeVisitorFor(
      final File file, final CompilationUnit cu) {
    for (PhysicalLocation location : locations) {
      try {
        if (looksTheSame(location, file)) {
          return new JEXLInjectionVisitor(getAllLocationsWithSameFile(location));
        }
      } catch (IOException e) {
        LOG.error("Problem assessing if rule matches file: {}", file, e);
      }
    }
    return new DoNothingVisitor();
  }

  @Override
  public String ruleId() {
    return JEXLInjectionRuleId;
  }

  private List<PhysicalLocation> getAllLocationsWithSameFile(final PhysicalLocation location) {
    return locations.stream()
        .filter(
            loc ->
                loc.getArtifactLocation().getUri().equals(location.getArtifactLocation().getUri()))
        .collect(Collectors.toUnmodifiableList());
  }

  private boolean looksTheSame(final PhysicalLocation physicalLocation, final File file)
      throws IOException {
    String filePath = file.getCanonicalPath();
    String fileUri = physicalLocation.getArtifactLocation().getUri();
    return filePath.startsWith(repositoryRootPath) && filePath.endsWith(fileUri);
  }

  private static class JEXLInjectionVisitor extends ModifierVisitor<FileWeavingContext> {
    private final List<PhysicalLocation> locations;

    private JEXLInjectionVisitor(final List<PhysicalLocation> locations) {
      this.locations = Objects.requireNonNull(locations);
    }

    @Override
    public Visitable visit(final NameExpr nameExpr, final FileWeavingContext context) {
      Predicate<PhysicalLocation> matchLocation =
          pl ->
              nameExpr
                  .getRange()
                  .map(
                      r ->
                          pl.getRegion().getStartLine() == r.begin.line
                              && pl.getRegion().getStartColumn() == r.begin.column
                              && pl.getRegion().getEndLine() == r.end.line
                              && pl.getRegion().getEndColumn() - 1 == r.end.column)
                  .orElse(false);

      // Checks if a PhysicalLocation matches nameExpr location
      if (locations.stream().anyMatch(matchLocation)) {
        JEXLInjectionFixer.checkAndFix(nameExpr)
            .map(i -> Weave.from(i, JEXLInjectionRuleId))
            .ifPresent(context::addWeave);
      }

      return super.visit(nameExpr, context);
    }

    @Override
    public Visitable visit(final MethodCallExpr methodCallExpr, final FileWeavingContext context) {
      Predicate<PhysicalLocation> matchLocation =
          pl ->
              methodCallExpr
                  .getRange()
                  .map(
                      r ->
                          pl.getRegion().getStartLine() == r.begin.line
                              && pl.getRegion().getStartColumn() == r.begin.column
                              && pl.getRegion().getEndLine() == r.end.line
                              && pl.getRegion().getEndColumn() - 1 == r.end.column)
                  .orElse(false);

      // Checks if a PhysicalLocation matches methodCallExpr location
      if (locations.stream().anyMatch(matchLocation)) {
        JEXLInjectionFixer.checkAndFix(methodCallExpr)
            .map(
                i ->
                    Weave.from(
                        i, JEXLInjectionRuleId, DependencyGAV.OPENPIXEE_JAVA_SECURITY_TOOLKIT))
            .ifPresent(context::addWeave);
      }

      return super.visit(methodCallExpr, context);
    }
  }

  private static final String JEXLInjectionRuleId = "codeql:java/jexl-expression-injection";
  private static final Logger LOG = LoggerFactory.getLogger(JEXLInjectionVisitorFactory.class);
}
