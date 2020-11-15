package kz.zhanbolat.files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FastFileMoverNewerNIO extends AbstractFastFileMover implements FastFileMover {
    private static final Logger logger = LogManager.getLogger(FastFileMoverNewerNIO.class);

    @Override
    public void moveFile(String from, String to) {
        File fromFile = new File(from);
        File toFile = new File(to);

        checkFiles(fromFile, toFile);

        try {
            if (toFile.isDirectory() ) {
                toFile = createToFile(new File(to + '/' + fromFile.getName()).toPath());
            }
            Files.move(fromFile.toPath(), toFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            logger.error(e);
        }
    }
}
