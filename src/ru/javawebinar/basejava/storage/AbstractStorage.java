package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    public void update(Resume resume) {
        updateIndex(checkIndex(resume.getUuid()), resume);
    }

    public void delete(String uuid) {
        deleteDeletedElement(checkIndex(uuid), uuid);
    }

    public Resume get(String uuid) {
        return getResume(checkIndex(uuid), uuid);
    }

    private int checkIndex(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return index;
    }

    public abstract void save(Resume resume);

    public abstract void clear();

    public abstract Resume[] getAll();

    protected abstract void updateIndex(int index, Resume resume);

    protected abstract void deleteDeletedElement(int index, String uuid);

    protected abstract Resume getResume(int index, String uuid);

    protected abstract int getIndex(String uuid);
}

