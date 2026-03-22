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

package jadex.gradle;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.tooling.provider.model.ToolingModelBuilderRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.net.URISyntaxException;

public class JadexPlugin implements Plugin<Project> {

    private static final Logger log = LoggerFactory.getLogger(JadexPlugin.class);

    private final ToolingModelBuilderRegistry registry;

    @Inject
    public JadexPlugin(ToolingModelBuilderRegistry registry) {
        this.registry = registry;
    }

    @Override
    public void apply(Project project) {

        JadexExtension extension =
                project.getExtensions().create("jadex", JadexExtension.class);

        registry.register(new JadexModelBuilder());

        project.getTasks().register("compileJadex", JadexCompileTask.class, task -> {

            task.setSourceDir(project.file(extension.getSourceDir()));
            task.setOutputDir(project.file(extension.getOutputDir()));

        });

        project.getTasks()
                .named("compileJava")
                .configure(t -> t.dependsOn("compileJadex"));

        project.getRepositories().mavenCentral();
        project.getDependencies().add("compileOnly", "org.jspecify:jspecify:1.0.0");

        try {
            project.getDependencies().add(
                    "implementation",
                    project.files(getClass().getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI())
            );
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        project.afterEvaluate(p -> {

            JavaPluginExtension javaExt =
                    p.getExtensions().getByType(JavaPluginExtension.class);

            javaExt.getSourceSets()
                    .getByName("main")
                    .getJava()
                    .srcDirs(
                            p.file(extension.getSourceDir()),
                            p.file(extension.getOutputDir())
                    );

            javaExt.getSourceSets()
                    .getByName("main")
                    .getJava()
                    .getSrcDirs()
                    .forEach(file -> log.debug("sourceDirs = " + file.toString()));
        });
    }
}