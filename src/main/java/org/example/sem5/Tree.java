package org.example.sem5;

import java.io.File;

public class Tree {

    /**
     * TODO: Доработать метод print, необходимо распечатать директории и файлы
     * @param args
     */
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());


        File[] files = file.listFiles();

        int subDirTotal = 0;
        int subFileTotal = 0;
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() && !files[i].isHidden()) {
                    subDirTotal++;
                } else if (files[i].isFile() && !files[i].isHidden()) {
                    subFileTotal++;
                }
            }


            int subDirCounter = 0;
            int subFileCounter = 0;
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory() && !files[i].isHidden()) {
                    print(files[i], indent, subDirTotal == ++subDirCounter);
                } else if (files[i].isFile() && !files[i].isHidden()) {
                    print(files[i], indent, subFileTotal == ++subFileCounter);
                }
            }
        }

    }

}
