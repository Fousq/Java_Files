package kz.zhanbolat.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public abstract class AbstractFastFileMover {

    protected void checkFiles(File from, File to) {
        if (!(from.exists() && to.exists())) {
            throw new IllegalArgumentException("One of the file doesn't exists");
        }
        if (from.isDirectory()) {
            throw new IllegalArgumentException("No file to move");
        }
    }

    protected String read(InputStream inputStream) throws IOException {
        StringBuilder builder = new StringBuilder();
        int read;
        while((read = inputStream.read()) != -1) {
            builder.append((char) read);
        }
        return builder.toString();
    }

    protected FileOutputStream determineToFileWriter(File toFile, String fromFileName) throws IOException {
        if (toFile.isFile()) {
            return new FileOutputStream(toFile);
        } else {
            File createdToFile = createToFile(new File(toFile.getAbsolutePath().concat("/" + fromFileName)).toPath());
            return new FileOutputStream(createdToFile);
        }
    }

    protected File createToFile(Path toPath) throws IOException {
        if (!toPath.toFile().exists()) {
            Path filePath = Files.createFile(toPath);
            return filePath.toFile();
        }
        return toPath.toFile();
    }
}
