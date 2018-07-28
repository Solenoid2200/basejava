package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    public Map<String, Resume> storage = new HashMap<>();

    @Override
    protected int getIndex(String uuid) {
        if (storage.containsKey(uuid)) {
            return 0;
        }
        return -1;
    }

    @Override
    protected void insertElement(Resume resume, int index) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateIndex(int index, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteDeletedElement(int index, String uuid) {
        storage.remove(uuid);
    }

    @Override
    public void clear() {
        storage.clear();
        size = 0;
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    public Resume[] getAll() {
        Map<String, Resume> map = Collections.synchronizedMap(storage);
        Resume[] result = new Resume[map.size()];
        int count = 0;
        for (Map.Entry<String, Resume> pair : map.entrySet()) {
            result[count] = pair.getValue();
            count++;
        }
        Arrays.sort(result);
        return result;
    }
}
