package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.List;
import java.util.Map;

public interface Storage {

    void save(Resume resume);

    void update(Resume resume);

    void delete(String uuid);

    void clear();

    Resume get(String uuid);

    Resume[] getAllFromArray();

    List<Resume> getAllFromList();

    Map<String, Resume> getAllFromMap();

    int size();
}