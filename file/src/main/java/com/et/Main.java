package com.et;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String privateKeys = "D:/IdeaProjects/Java-demo/file/src/main/resources/privateKeys.keystore";
        String publicCerts = "D:/IdeaProjects/Java-demo/file/src/main/resources/publicCerts.keystore";
        FileMerger.merger(privateKeys,publicCerts);
        String mergedFile = "D:/IdeaProjects/Java-demo/file/src/main/resources/merge.keystore";
        FileSplitter.split(mergedFile);
    }
}