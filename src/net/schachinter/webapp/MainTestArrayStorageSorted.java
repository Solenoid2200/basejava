package net.schachinter.webapp;

import net.schachinter.webapp.model.Resume;
import net.schachinter.webapp.storage.ArrayStorage;
import net.schachinter.webapp.storage.SortedArrayStorage;

/**
 * Test for ArrayStorage
 */
public class MainTestArrayStorageSorted {
    static final SortedArrayStorage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r6 = new Resume();
        r6.setUuid("uuid6");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r5 = new Resume();
        r5.setUuid("uuid5");

        ARRAY_STORAGE.save(r6);
        System.out.println("\nSize: " + ARRAY_STORAGE.size());
        printAll();

        ARRAY_STORAGE.save(r3);
        System.out.println("\nSize: " + ARRAY_STORAGE.size());
        printAll();

        ARRAY_STORAGE.save(r4);
        System.out.println("\nSize: " + ARRAY_STORAGE.size());
        printAll();

        ARRAY_STORAGE.save(r2);
        System.out.println("\nSize: " + ARRAY_STORAGE.size());
        printAll();

        ARRAY_STORAGE.save(r1);
        System.out.println("\nSize: " + ARRAY_STORAGE.size());
        printAll();

        ARRAY_STORAGE.save(r5);
        System.out.println("\nSize: " + ARRAY_STORAGE.size());
        printAll();
        /*
        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());

        */
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}