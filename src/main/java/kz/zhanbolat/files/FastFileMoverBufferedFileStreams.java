package kz.zhanbolat.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FastFileMoverBufferedFileStreams extends AbstractFastFileMover implements FastFileMover {
    private static final Logger logger = LogManager.getLogger(FastFileMoverBufferedFileStreams.class);
    private static final int BUFFER_SIZE = 1000;

    @Override
    public void moveFile(String from, String to) {
        File fromFile = new File(from);
        File toFile = new File(to);

        checkFiles(fromFile, toFile);

        try (FileInputStream fileInputStream = new FileInputStream(fromFile);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream, BUFFER_SIZE)) {
            String content = read(bufferedInputStream);

            FileOutputStream fileOutputStream = determineToFileWriter(toFile, fromFile.getName());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream, BUFFER_SIZE);
            bufferedOutputStream.write(content.getBytes());

            bufferedOutputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
