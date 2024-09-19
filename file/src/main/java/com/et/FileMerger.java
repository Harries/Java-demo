package com.et;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;


public class FileMerger {

    public static void main(String[] args) {
        String privateKeys = "D:/IdeaProjects/Java-demo/file/src/main/resources/privateKeys.keystore";
        String publicCerts = "D:/IdeaProjects/Java-demo/file/src/main/resources/publicCerts.keystore";
        merger(privateKeys,publicCerts);

    }
    public static String merger(String privateKeys, String publicCerts) {
        String directoryPath = FileUtils.extractDirectoryPath(privateKeys);
        String mergedFile =directoryPath+"merge.keystore";

        try {
            byte[] privateKeysContent =   FileUtils.readBinaryFile(privateKeys);
            byte[] publicCertsContent =   FileUtils.readBinaryFile(publicCerts);


            // create outputStream
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            // write keystore length（4 byte）
            outputStream.write(ByteBuffer.allocate(4).putInt(privateKeysContent.length).array());

            // write keystore content
            outputStream.write(privateKeysContent);

            // witer license content（4 byte int ）
            outputStream.write(ByteBuffer.allocate(4).putInt(publicCertsContent.length).array());

            // write license content
            outputStream.write(publicCertsContent);

            // write merge content to file
            FileUtils.writeBinaryFile(mergedFile, outputStream.toByteArray());
          
            System.out.println("merge success " + mergedFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mergedFile;
    }



}
