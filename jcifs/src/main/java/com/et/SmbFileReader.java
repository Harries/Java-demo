package com.et;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileInputStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SmbFileReader {
    public static void main(String[] args) {
        String user = "xxx"; // Username for the shared folder
        String password = "xxx"; // Password for the shared folder
        String sharedFolderUrl = "smb://BJDPLHHUAPC/test/"; // URL of the shared folder

        // Create an authentication object
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user + ":" + password);

        try {
            // Create an SmbFile object for the shared folder
            SmbFile sharedFolder = new SmbFile(sharedFolderUrl, auth);

            // List the files in the shared folder
            SmbFile[] files = sharedFolder.listFiles();
            for (SmbFile file : files) {
                System.out.println("File: " + file.getName());

                // If it is a file, read its content
                if (!file.isDirectory()) {
                    try (SmbFileInputStream fis = new SmbFileInputStream(file);
                         BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
                        String line;
                        // Read the file line by line
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line); // Print each line
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // Print the stack trace in case of an exception
        }
    }
}