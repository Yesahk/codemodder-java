package io.codemodder.providers.sarif.pmd;

import com.contrastsecurity.sarif.SarifSchema210;
import java.nio.file.Path;
import java.util.List;

/** Responsible for running PMD */
public interface PmdRunner {

  /**
   * Execute PMD.
   *
   * @param ruleIds the rule IDs to run (the rules must be in the default PMD ruleset)
   * @param codeDir the directory containing the code to be run on
   * @return the resulting SARIF
   */
  SarifSchema210 run(List<String> ruleIds, Path codeDir);

  static PmdRunner createDefault() {
    return new DefaultPmdRunner();
  }
}
