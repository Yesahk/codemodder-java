package io.codemodder.codemods.integration.tests;

import io.codemodder.codemods.integration.util.CodemodIntegrationTestMixin;
import io.codemodder.codemods.integration.util.IntegrationTestMetadata;
import io.codemodder.codemods.integration.util.IntegrationTestPropertiesMetadata;

@IntegrationTestMetadata(
    codemodId = "move-switch-default-last",
    tests = {
      @IntegrationTestPropertiesMetadata(endpoint = "/test?day=1", expectedResponse = "Monday")
    })
public class MoveSwitchDefaultCaseLastCodemodIntegrationTest
    implements CodemodIntegrationTestMixin {}
