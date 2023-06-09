plugins {
    id("io.codemodder.base")
    id("io.codemodder.java-library")
    id("io.codemodder.maven-publish")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

dependencies {
    compileOnly(libs.jetbrains.annotations)
    implementation("io.codemodder:codemodder-core")
    implementation("com.google.inject:guice:5.1.0")
    implementation("com.contrastsecurity:contrast-sdk-java:3.4.2")
    implementation("io.github.classgraph:classgraph:4.8.160")

    testImplementation(testlibs.bundles.junit.jupiter)
    testImplementation(testlibs.bundles.hamcrest)
    testImplementation(testlibs.assertj)
    testImplementation(testlibs.jgit)
    testImplementation(testlibs.mockito)
    testRuntimeOnly(testlibs.junit.jupiter.engine)
}
