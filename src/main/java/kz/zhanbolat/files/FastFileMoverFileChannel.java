package kz.zhanbolat.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FastFileMoverFileChannel extends AbstractFastFileMover implements FastFileMover {
    @Override
    public void moveFile(String from, String to) {
        File fromFile = new File(from);
        File toFile = new File(to);

        checkFiles(fromFile, toFile);
        try (FileInputStream fileInputStream = new FileInputStream(fromFile);
             FileChannel fileChannel = fileInputStream.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size());
            fileChannel.read(buffer);
            String content = new String(buffer.array());


            FileOutputStream fileOutputStream = determineToFileWriter(toFile, fromFile.getName());
            FileChannel writerChannel = fileOutputStream.getChannel();
            buffer = ByteBuffer.wrap(content.getBytes());
            writerChannel.write(buffer);

            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
