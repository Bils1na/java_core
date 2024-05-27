package org.example.hw5;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        makeDirectory(".");
        try (FileOutputStream fileOutputStream = new FileOutputStream("./backup/file.txt")) {
            fileOutputStream.write("Hello".getBytes());
        }
    }

    private static void createBackup() {

    }

    private static void copyFile(File fileName) {

    }

    private static void makeDirectory(String currentDirectory) {
        File newDirectory = new File(currentDirectory, "backup");

        if (!newDirectory.exists()) {
            newDirectory.mkdir();
        }
    }

}
