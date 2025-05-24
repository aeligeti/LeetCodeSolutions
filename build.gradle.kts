plugins {
    java
    id("com.github.spotbugs") version "6.0.22"
    id("checkstyle")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.junit.jupiter:junit-jupiter:5.10.2")
    testImplementation("org.assertj:assertj-core:3.26.3")
    testImplementation("org.openjdk.jmh:jmh-core:1.37")
    testImplementation("org.openjdk.jmh:jmh-generator-annprocess:1.37")
}
tasks.test {
    useJUnitPlatform()
    testLogging { events("passed", "skipped", "failed") }
}


