package com.et;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtils {

    static byte[] readBinaryFile(String filePath) throws IOException {
        File file = new File(filePath);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            return fileBytes;
        }
    }
    public static String extractDirectoryPath(String filePath) {
        File file = new File(filePath);
        return file.getParent()+File.separator; // 获取文件所在的目录
    }
     static void writeBinaryFile(String filePath, byte[] content) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(content);
        }
    }
}
