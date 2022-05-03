package io.pixee.codefixer.java;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.expr.MethodCallExpr;

import java.util.function.Predicate;

/**
 * This is meant to be consumed by rule writers to help them reduce boilerplate and reduce mistakes when writing code
 * to match certain conditions of code to match.
 */
public interface NodePredicateFactory {

    static Predicate<MethodCallExpr> withArgumentCount(final int numberOfArguments) {
        return new NumberOfArgumentsPredicate(numberOfArguments);
    }

    static Predicate<MethodCallExpr> withArgumentCodeContains(final int argumentIndex, final String searchStr) {
        return new ArgumentCodeContainsPredicate(argumentIndex, searchStr);
    }

    static Predicate<MethodCallExpr> withParentCodeContains(final String searchStr) {
        return new ParentCodeContainsPredicate(searchStr);
    }

    static Predicate<MethodCallExpr> withMethodName(final String name) {
        return new MethodNamePredicate(name);
    }

    static Predicate<MethodCallExpr> withScopeType(final CompilationUnit cu, final String name) {
        return new ScopeTypePredicate(cu, name);
    }

    static Predicate<MethodCallExpr> withArgumentType(final CompilationUnit cu, final int argumentIndex, final String name) {
        return new ArgumentTypePredicate(cu, argumentIndex, name);
    }

    static Predicate<MethodCallExpr> withArgumentNodeType(final int argumentIndex, final Class<? extends Node> nodeType) {
        return new ArgumentNodeTypePredicate(argumentIndex, nodeType);
    }

    static Predicate<MethodCallExpr> withScreamingSnakeCaseVariableNameForArgument(final int argumentIndex) {
        return new ArgumentIsScreamingSnakeCasePredicate(argumentIndex);
    }

    static Predicate<MethodCallExpr> withMethodPreviouslyCalledOnScope(final String methodName) {
        return new MethodPreviouslyCalledOnScope(methodName);
    }
}
