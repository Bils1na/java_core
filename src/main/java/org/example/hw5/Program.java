package org.example.hw5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Program {

    private static final String PARENT_DIRECTORY = ".";


    public static void main(String[] args) throws IOException {
        createBackup(new File(PARENT_DIRECTORY));
    }

    private static void createBackup(File parentDirectory) throws IOException {
        makeDirectory(PARENT_DIRECTORY, "backup");

        File[] files = parentDirectory.listFiles();
        for (File file : files) {
            copyFile(file);
        }
    }

    private static void copyFile(File fileName) throws IOException {
        File source = new File(String.valueOf(fileName));
        File copy = new File(String.format(".\\backup\\%s", fileName.toString().substring(2)));

        if (source.isDirectory() && !source.isHidden() && !source.toString().equals(".\\backup")) {
             makeDirectory(".\\backup\\", source.toString().substring(2));
             for (File subFile : source.listFiles()) {
                 copyFile(subFile);
             }
        } else if (source.isFile()) {
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream fileInputStream = new FileInputStream(source)) {
                int c = 0;
                try (FileOutputStream fileOutputStream = new FileOutputStream(copy)) {
                    while ((c = fileInputStream.read()) != -1) {
                        stringBuilder.append((char) c);
                    }
                    fileOutputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
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
