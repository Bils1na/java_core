package org.example.hw5;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Program {

    private static final String PARENT_DIRECTORY = ".";


    public static void main(String[] args) throws IOException {
        long timeStart = System.nanoTime();
        createBackup(new File(PARENT_DIRECTORY));
        double deltaTime = (System.nanoTime() - timeStart) * 0.000000001;
        System.out.println(deltaTime);
    }

    /**
     * Создает backup для файлов проекта
     * @param parentDirectory файл проекта
     * @throws IOException
     */
    private static void createBackup(File parentDirectory) throws IOException {
        makeDirectory(PARENT_DIRECTORY, "backup");

        File[] files = parentDirectory.listFiles();
        for (File file : files) {
            copyFile(file);
        }
    }

    /**
     * Создает копию файла
     * @param file оригинальный файл
     * @throws IOException
     */
    private static void copyFile(File file) throws IOException {
        File source = new File(String.valueOf(file));
        File copy = new File(String.format(".\\backup\\%s", file.toString().substring(2)));

        if (source.isDirectory() && !source.isHidden()
                && !source.toString().equals(".\\backup")) {
             makeDirectory(".\\backup\\",
                     source.toString().substring(2));
             for (File subFile : source.listFiles()) {
                 copyFile(subFile);
             }
        } else if (source.isFile()) {
            StringBuilder stringBuilder = new StringBuilder();
            try (FileInputStream fileInputStream = new FileInputStream(source)) {
                int symbol = 0;
                try (FileOutputStream fileOutputStream = new FileOutputStream(copy)) {
                    while ((symbol = fileInputStream.read()) != -1) {
                        stringBuilder.append((char) symbol);
//                        fileOutputStream.write(symbol);
                    }
                    fileOutputStream.write(stringBuilder.toString().getBytes(StandardCharsets.UTF_8));
                }
            }
        }
    }

    /**
     * Создает новую папку
     * @param dir1 путь к папке 1
     * @param dir2 путь к папке 2
     */
    private static void makeDirectory(String dir1, String dir2) {
        File newDirectory = new File(dir1, dir2);

        if (!newDirectory.exists()) {
            newDirectory.mkdir();
        }
    }

}
