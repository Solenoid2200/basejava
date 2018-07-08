package net.schachinter.webapp.storage;

import net.schachinter.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        if(size > storage.length-1) {
            System.out.println("Array is filled!");
            return;
        }
        if(getIndex(resume.getUuid()) !=-1) {
            System.out.println("net.schachinter.webapp.model.Resume exist!");
            return;
        }
        storage[size] = resume;
        size++;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if(index !=-1) {
            return storage[index];
        }
        System.out.println("net.schachinter.webapp.model.Resume not exist!");
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if(index != -1) {
            storage[index] = resume;
            return;
        }
        System.out.println("net.schachinter.webapp.model.Resume not exist!");
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if(index !=-1) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
        System.out.println("net.schachinter.webapp.model.Resume not exist!");
    }

    public int size() {
        return size;
    }

    private int getIndex(String incUuid) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(incUuid)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
