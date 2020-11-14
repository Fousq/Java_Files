package kz.zhanbolat.files;

import java.io.File;
import java.util.*;

public class DiskAnalyzeStatistic {
    private File fileWithMaxSLetterName;
    private List<File> largestFiles;
    private Map<Character, Integer> alphabetFilesNumberMap;
    private Map<Character, Integer> alphabetFolderNumberMap;
    private Map<String, Double> directoryAverageSizeMap;

    public DiskAnalyzeStatistic() {
        largestFiles = new ArrayList<>(5);
        alphabetFilesNumberMap = new HashMap<>();
        alphabetFolderNumberMap = new HashMap<>();
        directoryAverageSizeMap = new HashMap<>();
    }

    public File getFileWithMaxSLetterName() {
        return fileWithMaxSLetterName;
    }

    public void setFileWithMaxSLetterName(File fileWithMaxSLetterName) {
        this.fileWithMaxSLetterName = fileWithMaxSLetterName;
    }

    public List<File> getLargestFiles() {
        return Collections.unmodifiableList(largestFiles);
    }

    public void setLargestFiles(List<File> largestFiles) {
        this.largestFiles = largestFiles;
    }

    public Map<Character, Integer> getAlphabetFilesNumberMap() {
        return Collections.unmodifiableMap(alphabetFilesNumberMap);
    }

    public void setAlphabetFilesNumberMap(Map<Character, Integer> alphabetFilesNumberMap) {
        this.alphabetFilesNumberMap = alphabetFilesNumberMap;
    }

    public Map<Character, Integer> getAlphabetFolderNumberMap() {
        return Collections.unmodifiableMap(alphabetFolderNumberMap);
    }

    public void setAlphabetFolderNumberMap(Map<Character, Integer> alphabetFolderNumberMap) {
        this.alphabetFolderNumberMap = alphabetFolderNumberMap;
    }

    public Map<String, Double> getDirectoryAverageSizeMap() {
        return Collections.unmodifiableMap(directoryAverageSizeMap);
    }

    public void setDirectoryAverageSizeMap(Map<String, Double> directoryAverageSizeMap) {
        this.directoryAverageSizeMap = directoryAverageSizeMap;
    }

    public void addLargestFile(File file) {
        largestFiles.add(file);
    }

    public File getLargestFile(int index) {
        return largestFiles.get(index);
    }

    public void setLargestFiles(int index, File file) {
        largestFiles.set(index, file);
    }

    public boolean isLargestFilesInsertable() {
        return largestFiles.size() < 5;
    }

    public int getLargestFilesSize() {
        return largestFiles.size();
    }

    public void incrementAlphabetFilesCounter(File file) {
        incrementAlphabetCounter(file, alphabetFilesNumberMap);
    }

    public void incrementAlphabetFoldersCounter(File folder) {
        incrementAlphabetCounter(folder, alphabetFolderNumberMap);
    }

    private void incrementAlphabetCounter(File file, Map<Character, Integer> alphabetNumberMap) {
        char firstLetter = file.getName().charAt(0);
        if (Character.isAlphabetic(firstLetter)) {
            final char lowerCasedLetter = Character.toLowerCase(firstLetter);
            if (alphabetNumberMap.containsKey(firstLetter)) {
                int counter = alphabetNumberMap.get(firstLetter);
                alphabetNumberMap.put(lowerCasedLetter, ++counter);
            } else {
                alphabetNumberMap.put(lowerCasedLetter, 1);
            }
        }
    }

    public int getAlphabetFilesCounter(Character letter) {
        return alphabetFilesNumberMap.getOrDefault(letter, 0);
    }

    public int getAlphabetFoldersCounter(Character letter) {
        return alphabetFolderNumberMap.getOrDefault(letter, 0);
    }

    public void putDirectoryAverageSize(String key, double value) {
        directoryAverageSizeMap.put(key, value);
    }

    public void clear() {
        fileWithMaxSLetterName = null;
        largestFiles.clear();
        alphabetFilesNumberMap.clear();
        alphabetFolderNumberMap.clear();
        directoryAverageSizeMap.clear();
    }
}
