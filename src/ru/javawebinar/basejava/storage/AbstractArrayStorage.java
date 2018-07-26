package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    public Resume[] storage = new Resume[STORAGE_LIMIT];

    public void updateIndex(int index, Resume resume) {
        storage[index] = resume;
    }

    protected void deleteDeletedElement(int index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
    }

    protected abstract void fillDeletedElement(int index);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume getResume(int index) {
        return storage[index];
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }
}