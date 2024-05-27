package org.example.hw5;

import java.io.*;

public class Program {

    public static void main(String[] args) throws IOException {
        createBackup(new File("."));
    }

    private static void createBackup(File parentDirectory) throws IOException {
        makeDirectory(".", "backup");

        File[] files = parentDirectory.listFiles();
        for (File file : files) {
            copyFile(file);
        }
    }

    private static void copyFile(File fileName) throws IOException {
        File source = new File(String.valueOf(fileName));
        File copy = new File(String.format("%s", fileName));
        try (FileInputStream fileInputStream = new FileInputStream(source)) {
            int c = 0;
            try (FileOutputStream fileOutputStream = new FileOutputStream(copy)) {
                while ((c = fileInputStream.read()) != -1) {
                    fileOutputStream.write(c);
                }
            }
        }
    }

    private static void makeDirectory(String currentDirectory, String newDirectoryName) {
        File newDirectory = new File(currentDirectory, newDirectoryName);

        if (!newDirectory.exists()) {
            newDirectory.mkdir();
        }
    }

}
