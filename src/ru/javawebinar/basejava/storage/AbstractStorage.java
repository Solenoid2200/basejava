package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    // Abstract methods from "Implemented methods"
    protected abstract void doSave(Resume resume, int index);

    protected abstract void doUpdate(int index, Resume resume);

    protected abstract void doDelete(int index, String uuid);

    protected abstract Resume doGet(int index, String uuid);

    protected abstract int getKey(String uuid);

    // Implemented methods
    public void save(Resume resume) {
        int index = getKeyIfNotExist(resume.getUuid());
        doSave(resume, index);
    }

    public void update(Resume resume) {
        doUpdate(getKeyIfExist(resume.getUuid()), resume);
    }

    public void delete(String uuid) {
        doDelete(getKeyIfExist(uuid), uuid);
    }

    public Resume get(String uuid) {
        return doGet(getKeyIfExist(uuid), uuid);
    }

    // Private methods
    private int getKeyIfExist(String uuid) {
        int index = getKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private int getKeyIfNotExist(String uuid) {
        int index = getKey(uuid);
        if (index > -1) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}

