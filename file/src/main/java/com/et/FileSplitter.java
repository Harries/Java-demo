package com.et;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class FileSplitter {

    public static void main(String[] args) {
        String mergedFile = "D:/IdeaProjects/Java-demo/file/src/main/resources/merge.keystore";
        split(mergedFile);

    }
    private static void debugContent(byte[] content, String fileName) {
        System.out.printf("File: %s%n", fileName);
        System.out.printf("Length: %d%n", content.length);
        System.out.print("Content: ");
        for (byte b : content) {
            System.out.printf("%02X ", b);
        }
        System.out.println();
    }
    static String[] split(String mergedFile) {
        String directoryPath = FileUtils.extractDirectoryPath(mergedFile);
        String privateKeysFile = directoryPath + ".privateKeys.keystore";
        String publicCertsFile = directoryPath + ".publicCerts.keystore";
        String[] filePaths = new String[]{privateKeysFile, publicCertsFile};

        try {
            // read merge content
            byte[] mergedContent = FileUtils.readBinaryFile(mergedFile);

            // use ByteBuffer parse
            ByteBuffer buffer = ByteBuffer.wrap(mergedContent);

            // read privateKeys content length
            int privateKeysLength = buffer.getInt();

            // read privateKeys content
            byte[] privateKeysContent = new byte[privateKeysLength];
            buffer.get(privateKeysContent);

            // read publicCerts content length
            int publicCertsLength = buffer.getInt();

            // read publicCerts content
            byte[] publicCertsContent = new byte[publicCertsLength];
            buffer.get(publicCertsContent);

            // write privateKeys and publicCerts content to file
            FileUtils.writeBinaryFile(privateKeysFile, privateKeysContent);
            FileUtils.writeBinaryFile(publicCertsFile, publicCertsContent);

            System.out.println("merge file split " + privateKeysFile + " and " + publicCertsFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePaths;
    }






    private static byte[] extractContent(byte[] mergedContent, byte[] beginMarker, byte[] endMarker) {
        int beginIndex = indexOf(mergedContent, beginMarker);
        int endIndex = indexOf(mergedContent, endMarker, beginIndex);

        if (beginIndex != -1 && endIndex != -1) {
            // Move past the start marker
            beginIndex += beginMarker.length;

            // Adjust endIndex to exclude the end marker
            int adjustedEndIndex = endIndex;

            // Extract content
            return Arrays.copyOfRange(mergedContent, beginIndex, adjustedEndIndex);
        } else {
            return new byte[0]; // Return empty array if markers are not found
        }
    }


    private static byte[] removeEmptyLines(byte[] content) {
        // Convert byte array to list of lines
        List<byte[]> lines = splitIntoLines(content);

        // Filter out empty lines
        lines = lines.stream()
                .filter(line -> line.length > 0)
                .collect(Collectors.toList());

        // Reassemble content
        return mergeLines(lines);
    }

    private static List<byte[]> splitIntoLines(byte[] content) {
        List<byte[]> lines = new ArrayList<>();
        int start = 0;

        for (int i = 0; i < content.length; i++) {
            if (content[i] == '\n') { // Line break
                lines.add(Arrays.copyOfRange(content, start, i));
                start = i + 1;
            }
        }

        if (start < content.length) {
            lines.add(Arrays.copyOfRange(content, start, content.length));
        }

        return lines;
    }

    private static byte[] mergeLines(List<byte[]> lines) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        for (byte[] line : lines) {
            try {
                outputStream.write(line);
                outputStream.write('\n'); // Re-add line break
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return outputStream.toByteArray();
    }

    private static int indexOf(byte[] array, byte[] target) {
        return indexOf(array, target, 0);
    }

    private static int indexOf(byte[] array, byte[] target, int start) {
        for (int i = start; i <= array.length - target.length; i++) {
            if (Arrays.equals(Arrays.copyOfRange(array, i, i + target.length), target)) {
                return i;
            }
        }
        return -1; // Return -1 if target not found
    }






}
