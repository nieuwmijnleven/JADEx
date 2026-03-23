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

package jplus.plugin.intellij.gradle;

import jadex.gradle.JadexModel;
import org.gradle.tooling.GradleConnector;
import org.gradle.tooling.ProjectConnection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class GradleModelResolver {

    private static final Logger LOG = LoggerFactory.getLogger(GradleModelResolver.class);

    private JadexModel cachedModel = null;
    private long cacheTimestamp = 0;
    private static final long CACHE_TTL_MS = 20_000;

    public void invalidateCache() {
        cachedModel = null;
        cacheTimestamp = 0;
    }

    public JadexModel resolve(File buildGradleDir) {

        if (isCacheValid()) {
            return cachedModel;
        }

        return fetchViaToolingApi(buildGradleDir);
    }

    private boolean isCacheValid() {
        return cachedModel != null
            && (System.currentTimeMillis() - cacheTimestamp) < CACHE_TTL_MS;
    }

    private JadexModel fetchViaToolingApi(File buildGradleDir) {

        GradleConnector connector = GradleConnector.newConnector()
                .forProjectDirectory(buildGradleDir);

        try (ProjectConnection connection = connector.connect()) {

            JadexModel model = connection.getModel(JadexModel.class);

            cachedModel = model;
            cacheTimestamp = System.currentTimeMillis();

            return model;

        } catch (Exception e) {
            System.out.println("fetchViaToolingApi: " + e);
            return cachedModel;
        }
    }
}