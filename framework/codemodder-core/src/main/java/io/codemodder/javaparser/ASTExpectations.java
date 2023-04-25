package io.codemodder.javaparser;

import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.expr.VariableDeclarationExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import io.codemodder.ast.ASTs;
import io.codemodder.ast.LocalVariableDeclaration;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * A utility for validating the shape of ASTs and filtering them to retrieve. It only exposes one
 * endpoint, {@link #expect(Node)}, which allows folks to filter and telescope a further down an AST
 * subgraph.
 *
 * <p>The notable weakness of this API is use cases where you need to retrieve multiple parts of the
 * AST, but we have not run into that much as of yet.
 */
@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
public final class ASTExpectations {

  private ASTExpectations() {}

  /** A producer of an AST subgraph. */
  interface ASTExpectationProducer<T extends Node> {
    Optional<T> result();
  }

  /** The starting point for validating the shape of an AST and returning a subgraph. */
  public static NodeExpectation expect(final Node node) {
    return new NodeExpectation(node);
  }

  /** A type for querying and filtering generic AST nodes. */
  public static class NodeExpectation implements ASTExpectationProducer<Node> {

    private Optional<Node> nodeRef;

    public NodeExpectation(final Node node) {
      this.nodeRef = Optional.of(node);
    }

    /** Return an expectation that asserts the parent node is a {@link BlockStmt}. */
    public NodeExpectation withBlockParent() {
      if (nodeRef.isEmpty()) {
        return this;
      }
      nodeRef =
          nodeRef.filter(
              n -> n.getParentNode().filter(parent -> parent instanceof BlockStmt).isPresent());
      return this;
    }

    /**
     * Return an expectation that asserts the node is an {@link ExpressionStmt} with a {@link
     * VariableDeclarationExpr} for its expression.
     */
    public VariableDeclarationExprExpectation toBeVariableDeclarationStatement() {
      Optional<VariableDeclarationExpr> vde =
          nodeRef
              .map(n -> n instanceof ExpressionStmt ? (ExpressionStmt) n : null)
              .map(ExpressionStmt::getExpression)
              .map(
                  expr ->
                      expr.isVariableDeclarationExpr() ? expr.asVariableDeclarationExpr() : null);
      return new VariableDeclarationExprExpectation(vde);
    }

    @Override
    public Optional<Node> result() {
      return nodeRef;
    }
  }

  /** A type for querying and filtering variable declaration(s). */
  public static class VariableDeclarationExprExpectation
      implements ASTExpectationProducer<VariableDeclarationExpr> {
    private Optional<VariableDeclarationExpr> varDefExprRef;

    public VariableDeclarationExprExpectation(final Optional<VariableDeclarationExpr> expr) {
      this.varDefExprRef = expr;
    }

    /**
     * Return an expectation that asserts the local variable declaration has only a single variable.
     */
    public LocalVariableDeclaratorExpectation toBeSingleLocalVariableDefinition() {
      if (varDefExprRef.isEmpty()) {
        return new LocalVariableDeclaratorExpectation(Optional.empty());
      }
      VariableDeclarationExpr variableDeclarationExpr = varDefExprRef.get();
      if (variableDeclarationExpr.getVariables().size() != 1) {
        varDefExprRef = Optional.empty();
        return new LocalVariableDeclaratorExpectation(Optional.empty());
      }
      Optional<LocalVariableDeclaration> localVariableDeclaration =
          LocalVariableDeclaration.fromVariableDeclarator(variableDeclarationExpr.getVariable(0));
      if (localVariableDeclaration.isPresent()) {
        return new LocalVariableDeclaratorExpectation(
            Optional.of(variableDeclarationExpr.getVariables().get(0)));
      }
      return new LocalVariableDeclaratorExpectation(Optional.empty());
    }

    @Override
    public Optional<VariableDeclarationExpr> result() {
      return varDefExprRef;
    }
  }

  /** A type for querying and filtering a single variable declaration. */
  public static class LocalVariableDeclaratorExpectation
      implements ASTExpectationProducer<VariableDeclarator> {
    private Optional<VariableDeclarator> varRef;

    public LocalVariableDeclaratorExpectation(
        final Optional<VariableDeclarator> variableDeclarator) {
      this.varRef = Objects.requireNonNull(variableDeclarator);
    }

    /** Return an expectation that asserts the variable declaration has only a single variable. */
    public LocalVariableDeclaratorExpectation withDirectReferenceCount(final int count) {
      if (varRef.isEmpty()) {
        return this;
      }
      Optional<LocalVariableDeclaration> localVariableDeclaration =
          LocalVariableDeclaration.fromVariableDeclarator(varRef.get());
      if (localVariableDeclaration.isEmpty()) {
        varRef = Optional.empty();
        return this;
      }
      List<NameExpr> allReferences = ASTs.findAllReferences(localVariableDeclaration.get());
      if (allReferences.size() != count) {
        varRef = Optional.empty();
      }
      return this;
    }

    /** Return an expectation that asserts that the initializer is a {@link MethodCallExpr}. */
    public MethodCallExpectation toBeInitializedByMethodCall() {
      if (varRef.isEmpty()) {
        return new MethodCallExpectation(Optional.empty());
      }
      Optional<MethodCallExpr> mc =
          varRef
              .flatMap(VariableDeclarator::getInitializer)
              .filter(MethodCallExpr.class::isInstance)
              .map(MethodCallExpr.class::cast);

      if (mc.isEmpty()) {
        varRef = Optional.empty();
      }

      return new MethodCallExpectation(mc);
    }

    @Override
    public Optional<VariableDeclarator> result() {
      return varRef;
    }
  }

  /** A type for querying and filtering method call expressions. */
  public static class MethodCallExpectation implements ASTExpectationProducer<MethodCallExpr> {
    private final Optional<MethodCallExpr> methodCallExpr;

    public MethodCallExpectation(final Optional<MethodCallExpr> methodCallExpr) {
      this.methodCallExpr = Objects.requireNonNull(methodCallExpr);
    }

    @Override
    public Optional<MethodCallExpr> result() {
      return methodCallExpr;
    }
  }
}
