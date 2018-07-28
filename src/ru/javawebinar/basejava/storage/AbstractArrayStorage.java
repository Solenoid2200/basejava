package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class AbstractArrayStorage extends AbstractStorage {
    public Resume[] storage = new Resume[STORAGE_LIMIT];

    public void updateIndex(int index, Resume resume) {
        storage[index] = resume;
    }

    protected void deleteDeletedElement(int index, String uuid) {
        fillDeletedElement(index);
        storage[size - 1] = null;
    }

    protected abstract void fillDeletedElement(int index);

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public Resume getResume(int index, String uuid) {
        return storage[index];
    }

    public Resume[] getAllFromArray() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    public List<Resume> getAllFromList() {
        return null;
    }

    @Override
    public Map<String, Resume> getAllFromMap() {
        return null;
    }

}