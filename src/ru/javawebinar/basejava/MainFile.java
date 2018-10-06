package ru.javawebinar.basejava;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File("./src/ru/javawebinar/basejava");
        printDirectoryDeeply(dir, 0);
    }

    public static void printDirectoryDeeply(File dir, int count) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    String st = createIndent(count);
                    System.out.println(st + "File: " + file.getName());
                } else if (file.isDirectory()) {
                    String st = createIndent(count);
                    System.out.println(st + "Directory: " + file.getName());
                    printDirectoryDeeply(file, count+4);
                }
            }
        }
    }

    private static String createIndent(int count) {
        String result = "";
        for (int i = 0; i < count; i++) {
            result = result + " ";
        }
        return result;
    }

}
