package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> list = new ArrayList<>();

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(list.get(i).getUuid())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        list.add(resume);
    }

    @Override
    protected void updateIndex(int index, Resume resume) {
        list.set(index, resume);
    }

    @Override
    protected void deleteDeletedElement(int index, String uuid) {
        list.remove(index);
    }

    @Override
    public void clear() {
        list.clear();
        size = 0;
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return list.get(index);
    }

    @Override
    public Resume[] getAll() {
        return list.toArray(new Resume[list.size()]);
    }

}
