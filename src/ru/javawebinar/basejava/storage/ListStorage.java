package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    public List<Resume> storage = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        storage.add(resume);
    }

    @Override
    protected void updateIndex(int index, Resume resume) {
        storage.remove(index);
        storage.add(index, resume);
    }

    @Override
    protected void deleteDeletedElement(int index) {
        storage.remove(index);
    }

    @Override
    public void clear() {
        if (!storage.isEmpty()) {
            storage.clear();
            size = 0;
        }
    }

    @Override
    protected Resume getResume(int index) {
        return storage.get(index);
    }

    @Override
    public List<Resume> getAll() {
        return new ArrayList<Resume>(storage);
    }
}
