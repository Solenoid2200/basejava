package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<String, Resume> map = new HashMap<>();

    public void doSave(int index, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    public void doUpdate(int index, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    public void doDelete(int index, String uuid) {
        map.remove(uuid);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Resume doGet(int index, String uuid) {
        return map.get(uuid);
    }

    @Override
    protected int getKey(String uuid) {
        if (map.containsKey(uuid)) {
            return 0;
        }
        return -1;
    }

    @Override
    public Resume[] getAll() {
        Map<String, Resume> mapCopy = Collections.synchronizedMap(map);
        Resume[] result = new Resume[mapCopy.size()];
        result = mapCopy.values().toArray(result);
        Arrays.sort(result);
        return result;
    }


    @Override
    public int size() {
        return map.size();
    }
}
