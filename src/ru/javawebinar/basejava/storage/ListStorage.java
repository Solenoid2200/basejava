package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        storage.set(index, resume);
    }

    @Override
    protected void deleteDeletedElement(int index, String uuid) {
        storage.remove(index);
    }

    @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage.get(index);
    }

    @Override
    public Resume[] getAllFromArray() {
        return null;
    }

    @Override
    public List<Resume> getAllFromList() {
        return new ArrayList<>(storage);
    }

    @Override
    public Map<String, Resume> getAllFromMap() {
        return null;
    }
}
