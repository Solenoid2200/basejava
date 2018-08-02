package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    // Abstract methods from "Implemented methods"
    protected abstract void doSave(int index, Resume resume);

    protected abstract void doUpdate(int index, Resume resume);

    protected abstract void doDelete(int index, String uuid);

    protected abstract Resume doGet(int index, String uuid);

    protected abstract int getKey(String uuid);

    // Implemented methods
    public void save(Resume resume) {
        int index = getKeyIfNotExist(resume.getUuid());
        doSave(index, resume);
    }

    public void update(Resume resume) {
        int index = getKeyIfExist(resume.getUuid());
        doUpdate(index, resume);
    }

    public void delete(String uuid) {
        int index = getKeyIfExist(uuid);
        doDelete(index, uuid);
    }

    public Resume get(String uuid) {
        int index = getKeyIfExist(uuid);
        return doGet(index, uuid);
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

