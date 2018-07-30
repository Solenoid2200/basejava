package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    public Map<String, Resume> map = new HashMap<>();

    public void doSave(Resume resume, int index) {
        if (map.containsKey(resume.getUuid())) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            map.put(resume.getUuid(), resume);
        }
    }

    @Override
    public void updateResume(int index, Resume resume) {
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
    public Resume getResume(int index, String uuid) {
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
        int count = 0;
        for (Map.Entry<String, Resume> pair : map.entrySet()) {
            result[count] = pair.getValue();
            count++;
        }
        Arrays.sort(result);
        return result;
    }

    @Override
    public int size() {
        return map.size();
    }
}
