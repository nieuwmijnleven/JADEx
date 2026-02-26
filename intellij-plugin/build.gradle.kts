/*
 * JADEx - Java Advanced Development Extension
 *
 * Copyright (C) 2026 Cheol Jeon <nieuwmijnleven@outlook.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License version 2 only,
 * as published by the Free Software Foundation.
 *
 * Alternatively, this software may be used under a commercial license
 * from Cheol Jeon.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU General Public License version 2 for more details:
 * <https://www.gnu.org/licenses/old-licenses/gpl-2.0.html>.
 *
 * For commercial licensing, please contact <nieuwmijnleven@outlook.com>.
 *
 * Contributors to this project must sign a Contributor License Agreement (CLA)
 * granting Cheol Jeon the right to relicense their contributions under
 * a commercial license. See the CLA file in the project root for details.
 */

plugins {
    id("java")
    id("antlr")
    id("org.jetbrains.kotlin.jvm") version "2.1.0"
    id("org.jetbrains.intellij.platform") version "2.7.1"
}

group = "jplus.plugin.intellij"
version = "0.41"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

// Configure IntelliJ Platform Gradle Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html
dependencies {
    intellijPlatform {
        create("IC", "2025.1.4.1")
        testFramework(org.jetbrains.intellij.platform.gradle.TestFrameworkType.Platform)

        // Add necessary plugin dependencies for compilation here, example:
         bundledPlugin("com.intellij.java")
    }

    implementation(project(":app"))
    antlr("org.antlr:antlr4:4.12.0") { // use ANTLR version 4
        exclude(group="com.ibm.icu", module="icu4j")
    }
    implementation("org.antlr:antlr4-intellij-adaptor:0.1")
    implementation("org.jspecify:jspecify:1.0.0")
    implementation("org.bitbucket.cowwoc:diff-match-patch:1.2")
}

tasks.processResources {
    from(file("lib/jspecify-1.0.0.jar")) {
        into("libs")
    }
}

intellijPlatform {
    pluginConfiguration {
        ideaVersion {
            sinceBuild = "251"
        }

        changeNotes = """
            Initial version
        """.trimIndent()
    }

    pluginVerification {
        ides {
            create("IC", "2025.1.4.1") { }
            create("IC", "2025.2.1") { }
        }
    }
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "21"
        targetCompatibility = "21"
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21)
    }
}

tasks.named("generateGrammarSource", AntlrTask::class.java).configure {
    arguments.addAll(listOf("-visitor", "-package", "jplus.plugin.intellij"))
    outputDirectory = file("src/main/antlr/generated-src/jplus/plugin/intellij")
}

sourceSets {
    main {
        java {
            //srcDir("src/main/antlr/generated-src")
            srcDirs("src/main/antlr/generated-src")
        }
    }
}

gradle.taskGraph.whenReady {
    if (hasTask(":intellij-plugin:runIde")) {
        project(":app").tasks.named("generateGrammarSource").configure {
            setEnabled(false)
        }
        project(":app").tasks.named("generateTestGrammarSource").configure {
            setEnabled(false)
        }
        project(":intellij-plugin").tasks.named("generateGrammarSource").configure {
            setEnabled(false)
        }
        project(":intellij-plugin").tasks.named("generateTestGrammarSource").configure {
            setEnabled(false)
        }
    } else if (hasTask(":intellij-plugin:buildPlugin")) {
        project(":app").tasks.named("generateGrammarSource").configure {
            setEnabled(false)
        }
        project(":app").tasks.named("generateTestGrammarSource").configure {
            setEnabled(false)
        }
        project(":intellij-plugin").tasks.named("generateGrammarSource").configure {
            setEnabled(false)
        }
        project(":intellij-plugin").tasks.named("generateTestGrammarSource").configure {
            setEnabled(false)
        }
    }
}
