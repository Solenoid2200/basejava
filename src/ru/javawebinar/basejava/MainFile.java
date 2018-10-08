package ru.javawebinar.basejava;

import java.io.File;

public class MainFile {
    public static void main(String[] args) {
        File dir = new File("./src/ru/javawebinar/basejava");
        printDirectoryDeeply(dir, "    ");
    }

    public static void printDirectoryDeeply(File dir, String indent) {
        File[] files = dir.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    printDirectoryDeeply(file, indent + "    ");
                }
            }
        }
    }

}
