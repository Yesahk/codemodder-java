package io.pixee.codetl.java;

import io.pixee.codetl_antlr.CodeTLBaseListener;
import io.pixee.codetl_antlr.CodeTLLexer;
import io.pixee.codetl_antlr.CodeTLParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CodePointCharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

final class CodeTLParserTest {

    @ParameterizedTest
    @CsvSource({
            "rule pixee:java/stuff,pixee:java/stuff",
            "rule  pixee:java/stuff,pixee:java/stuff",
            "\nrule\tpixee:java/stuff,pixee:java/stuff",
            "\nrule\tpixee:python/stuff,pixee:python/stuff"
    })
    void it_compiles_correct(final String codetl, final String expectedRule) {
        CodeTLParser parser = getParser(codetl + " match MethodCall $c {} replace $c MethodCall {}");
        CodeTLParser.CodeTlRuleContext parsedRule = parser.codeTlRule();

        final CodeTLRuleDefinitionBuilder ruleBuilder = CodeTLRuleDefinitionBuilder.builder();
        CodeTLBaseListener listener = new CodeTLBaseListener() {
            @Override
            public void exitRule_statement(final CodeTLParser.Rule_statementContext ctx) {
                ruleBuilder.withRuleId(ctx.getChild(1).getText());
                super.exitRule_statement(ctx);
            }

            @Override
            public void exitCodeTlRule(final CodeTLParser.CodeTlRuleContext ctx) {
                super.exitCodeTlRule(ctx);
            }
        };

        ParseTreeWalker walker = new ParseTreeWalker();
        walker.walk(listener, parsedRule);

        CodeTLRuleDefinition rule = ruleBuilder.build();
        System.out.println("Rule: " + rule.getRuleId());
        assertThat(rule.getRuleId(), equalTo(expectedRule));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "rule=pixee:java/stuff", // wrong separator
            "rule pixeejava/stuff", // no namespace separator
            "rule pixee:java_stuff", // no language separator
    })
    void it_doesnt_parse_invalid(final String badRuleId) {
        CodeTLParser parser = getParser(badRuleId);
    }

    @NotNull
    private CodeTLParser getParser(final String ruleId) {
        CodePointCharStream stream = CharStreams.fromString(ruleId);
        CodeTLLexer lexer = new CodeTLLexer(stream);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new CodeTLParser(tokens);
    }
}
