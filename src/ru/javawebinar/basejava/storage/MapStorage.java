package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class MapStorage extends AbstractStorage {

    @Override
    protected int getIndex(String uuid) {
        return 0;
    }

    @Override
    protected void insertElement(Resume resume, int index) {

    }

    @Override
    protected void updateIndex(int index, Resume resume) {

    }

    @Override
    protected void deleteDeletedElement(int index) {

    }

    @Override
    public void clear() {

    }

    @Override
    protected Resume getResume(int index) {
        return null;
    }

    @Override
    public Object getAll() {
        return null;
    }
}
