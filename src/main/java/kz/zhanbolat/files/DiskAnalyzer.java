package kz.zhanbolat.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class DiskAnalyzer {
    private static final Logger logger = LogManager.getLogger(DiskAnalyzer.class);
    private static final char ALPHABET_START_LETTER = 'a';
    private static final char ALPHABET_END_LETTER = 'z';
    private DiskAnalyzeStatistic statistic;

    public DiskAnalyzer() {
        statistic = new DiskAnalyzeStatistic();
    }

    public void analyze(String path, int number) {
        if (Objects.isNull(path)) {
            throw new IllegalArgumentException("Path should be passed");
        }
        if (path.trim().isEmpty()) {
            throw new IllegalArgumentException("Path should not be empty");
        }
        if (number <= 0) {
            throw new IllegalArgumentException("Number should not be equal or below zero");
        }
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException("Path should exists");
        }

        if (!file.isDirectory()) {
           analyzeFile(file, number);
        } else {
            analyzeFolder(file, number);
        }
        try {
            final Path tempFilePath = Files.createTempFile("disk_analyze", "report");
            logger.info("Temp file was created, name = " + tempFilePath.getFileName() + ", path = " + tempFilePath);
            try (FileOutputStream fileOutputStream = new FileOutputStream(tempFilePath.toFile());
                 OutputStreamWriter stringWriter = new OutputStreamWriter(fileOutputStream)) {
                stringWriter.write(buildReport());
            }
        } catch (IOException e) {
            logger.error(e);
        }
        statistic.clear();
    }

    private AverageSizeResult analyzeFolder(File folder, int number) {
        statistic.incrementAlphabetFoldersCounter(folder);

        AverageSizeResult averageSizeResult = new AverageSizeResult();
        File[] files = folder.listFiles();

        if (files.length == 0) {
            return averageSizeResult;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                averageSizeResult.merge(analyzeFolder(file, number));
            } else {
                averageSizeResult.add(analyzeFile(file, number));
                averageSizeResult.incrementCounter();
            }
        }
        statistic.putDirectoryAverageSize(folder.getAbsolutePath(), averageSizeResult.averageSize());
        return averageSizeResult;
    }

    private long analyzeFile(File file, int number) {
        if (Objects.isNull(statistic.getFileWithMaxSLetterName())) {
            statistic.setFileWithMaxSLetterName(file);
        } else {
            updateFileWithMaxSLetterName(file);
        }

        if (statistic.isLargestFilesInsertable()) {
            statistic.addLargestFile(file);
        } else {
            for (int i = 0; i < statistic.getLargestFilesSize(); i++) {
                final File largestFile = statistic.getLargestFile(i);
                if (largestFile.length() < file.length()) {
                    statistic.setLargestFiles(i, file);
                    break;
                }
            }
        }

        statistic.incrementAlphabetFilesCounter(file);
        return file.length();
    }

    private void updateFileWithMaxSLetterName(File file) {

            final String name = file.getName();
            final long sCount = name.chars().filter(character -> Objects.equals(character, 's')).count();
            final long sCountMax = statistic.getFileWithMaxSLetterName().getName().chars()
                    .filter(character -> Objects.equals(character, 's')).count();
            if (sCount > sCountMax) {
                statistic.setFileWithMaxSLetterName(file);
            }
        }

    private String buildReport() {
        StringBuilder builder = new StringBuilder("Report of work\n");
        builder.append("Path to file name with the maximum number of letters 's': ")
                .append(statistic.getFileWithMaxSLetterName().getAbsolutePath())
                .append("\nTop 5 largest files in bytes:\n");
        AtomicInteger counter = new AtomicInteger(1);
        statistic.getLargestFiles().forEach(file -> builder.append(counter.getAndIncrement())
                .append(". ").append(file.getAbsolutePath()).append(" with size ").append(file.length()).append(System.lineSeparator()));

        builder.append("Average file size for each directory:\n");
        statistic.getDirectoryAverageSizeMap()
                .forEach((key, value) ->
                        builder.append("* ").append(key).append(" - ").append(value).append(System.lineSeparator()));

        builder.append("Number of files and folders, divided by the first letters of the alphabet:\n");
        IntStream.range(ALPHABET_START_LETTER, ALPHABET_END_LETTER + 1).forEach(codePoint -> {
            char letter = (char) codePoint;
            builder.append("Letter - ").append(letter)
                    .append(", files = ").append(statistic.getAlphabetFilesCounter(letter))
                    .append(", folders = ").append(statistic.getAlphabetFoldersCounter(letter))
                    .append(System.lineSeparator());
        });

        return builder.toString();
    }
}
