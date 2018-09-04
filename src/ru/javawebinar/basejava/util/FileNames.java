package ru.javawebinar.basejava.util;

import java.io.File;
import java.util.Objects;

public class FileNames {
    public static void main(String[] args) {
        printAllFiles(new File("c:/basejava"));
    }

    private static void printAllFiles(File directory) {
        for (File file : Objects.requireNonNull(directory.listFiles())) {
            if (file.isDirectory()) {
                printAllFiles(file);
            } else {
                System.out.println(file.getName());
            }
        }
    }
}
