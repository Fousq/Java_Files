package kz.zhanbolat.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FastFileMoverFileStreams extends AbstractFastFileMover implements FastFileMover {
    private static final Logger logger = LogManager.getLogger(FastFileMoverFileStreams.class);

    @Override
    public void moveFile(String from, String to) {
        File fromFile = new File(from);
        File toFile = new File(to);

        checkFiles(fromFile, toFile);

        try (FileInputStream fileInputStream = new FileInputStream(fromFile)) {
            String content = read(fileInputStream);

            FileOutputStream fileOutputStream = determineToFileWriter(toFile, fromFile.getName());
            fileOutputStream.write(content.getBytes());

            fileOutputStream.close();
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
