package net.schachinter.webapp.storage;

import net.schachinter.webapp.model.Resume;

public class AbstractArrayStorage implements Storage {

    protected final static int ARRAY_MAX_SIZE = 10000;
    protected Resume[] storage = new Resume[ARRAY_MAX_SIZE];
    protected int size = 0;

    @Override
    public void clear() {

    }

    @Override
    public void save(Resume resume) {

    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public Resume[] getAll() {
        return new Resume[0];
    }

    @Override
    public void update(Resume resume) {

    }

    @Override
    public void delete(String uuid) {

    }

    public int size() {
        return size;
    }

}
