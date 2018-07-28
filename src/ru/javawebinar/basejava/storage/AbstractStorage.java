package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    static final int STORAGE_LIMIT = 10000;
    protected int size = 0;

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    public void update(Resume resume) {
        updateIndex(checkIndex(resume.getUuid()), resume);
    }

    public void delete(String uuid) {
        deleteDeletedElement(checkIndex(uuid), uuid);
        size--;
    }

    public Resume get(String uuid) {
        return getResume(checkIndex(uuid), uuid);
    }

    public int size() {
        return size;
    }

    private int checkIndex(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    public abstract void clear();

    public abstract Resume[] getAll();

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void updateIndex(int index, Resume resume);

    protected abstract void deleteDeletedElement(int index, String uuid);

    protected abstract Resume getResume(int index, String uuid);
}

