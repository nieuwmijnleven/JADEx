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

package jplus.processor;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class DelombokRunner {

    private final Path lombokJarPath;

    public DelombokRunner(Path lombokJarPath) {
        this.lombokJarPath = lombokJarPath;
    }

    /**
     * Lombok 사용 여부 빠른 감지
     */
    public static boolean usesLombok(String sourceContent) {
        return sourceContent.lines()
            .anyMatch(line -> line.startsWith("import lombok."));
    }

    /**
     * 소스 내용을 받아 delombok 실행 후 결과 문자열 반환
     */
    public String run(String sourceContent, String className) throws Exception {
        Path tempDir = Files.createTempDirectory("delombok-in-");
        Path outputDir = Files.createTempDirectory("delombok-out-");

        try {
            // 임시 파일에 소스 내용 기록
            var fileName = className + ".java";
            Path tempSource = tempDir.resolve(fileName);
            Files.writeString(tempSource, sourceContent);

            // 별도 JVM 프로세스로 delombok 실행
            ProcessBuilder pb = new ProcessBuilder(
                "java", "-jar", lombokJarPath.toAbsolutePath().toString(),
                "delombok",
                    "--classpath", lombokJarPath.toAbsolutePath().toString(),
                    tempSource.toAbsolutePath().toString(),
                "-d", outputDir.toAbsolutePath().toString()
            );
            pb.redirectErrorStream(true);

            Process process = pb.start();

            // 프로세스 출력 수집 (버퍼 블로킹 방지)
            String processOutput;
            try (var reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                processOutput = reader.lines()
                    .collect(java.util.stream.Collectors.joining("\n"));
            }

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new IOException(
                    "Delombok 실패 (exit=" + exitCode + "): " + processOutput
                );
            }

            // 결과 파일 읽기
            Path result = outputDir.resolve(fileName);
            if (!Files.exists(result)) {
                throw new IOException("Delombok 출력 파일 없음: " + result);
            }
            return Files.readString(result);

        } finally {
            deleteRecursively(tempDir);
            deleteRecursively(outputDir);
        }
    }

    private static void deleteRecursively(Path dir) throws IOException {
        try (var walk = Files.walk(dir)) {
            walk.sorted(java.util.Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        }
    }
}