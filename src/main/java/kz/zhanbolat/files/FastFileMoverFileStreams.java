package kz.zhanbolat.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FastFileMoverFileStreams implements FastFileMover {
    private static final Logger logger = LogManager.getLogger(FastFileMoverFileStreams.class);

    @Override
    public void moveFile(String from, String to) {
        File fromFile = new File(from);
        File toFile = new File(to);

        if (!(fromFile.exists() && toFile.exists())) {
            throw new IllegalArgumentException("One of the file doesn't exists");
        }
        if (fromFile.isDirectory()) {
            throw new IllegalArgumentException("No file to move");
        }
        try (FileInputStream fileInputStream = new FileInputStream(fromFile)) {
            StringBuilder builder = new StringBuilder();
            int read;
            while((read = fileInputStream.read()) != -1) {
                builder.append((char) read);
            }
            FileOutputStream fileOutputStream;
            if (toFile.isFile()) {
                fileOutputStream = new FileOutputStream(toFile);
            } else {
                File createToFile = new File(toFile.getAbsolutePath().concat("/" + fromFile.getName()));
                File createdToFile;
                if (!createToFile.exists()) {
                    Path filePath = Files.createFile(createToFile.toPath());
                    createdToFile = filePath.toFile();
                } else {
                    createdToFile = createToFile;
                }
                fileOutputStream = new FileOutputStream(createdToFile);
            }
            fileOutputStream.write(builder.toString().getBytes());

            fileOutputStream.close();
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
