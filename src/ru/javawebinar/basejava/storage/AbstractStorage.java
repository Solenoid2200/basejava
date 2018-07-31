package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    // Abstract methods from Interface Storage
    public abstract void clear();

    public abstract Resume[] getAll();

    public abstract int size();

    // Abstract methods from "Implemented methods"
    protected abstract void doSave(Resume r, int index);

    protected abstract void doUpdateResume(int index, Resume resume);

    protected abstract void doDelete(int index, String uuid);

    protected abstract Resume doGetResume(int index, String uuid);

    protected abstract int getKey(String uuid);

    // Implemented methods
    public void save(Resume resume) {
        int index = checkIndexExistStorageException(resume.getUuid());
        doSave(resume, index);
    }

    public void update(Resume resume) {
        doUpdateResume(checkIndexNotExistStorageException(resume.getUuid()), resume);
    }

    public void delete(String uuid) {
        doDelete(checkIndexNotExistStorageException(uuid), uuid);
    }

    public Resume get(String uuid) {
        return doGetResume(checkIndexNotExistStorageException(uuid), uuid);
    }

    // Private methods
    private int checkIndexNotExistStorageException(String uuid) {
        int index = getKey(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    private int checkIndexExistStorageException(String uuid) {
        int index = getKey(uuid);
        if (index > -1) {
            throw new ExistStorageException(uuid);
        }
        return index;
    }
}

