package net.schachinter.webapp.storage;

import net.schachinter.webapp.model.Resume;

import java.util.Arrays;

public interface Storage {

    void clear();
    void save(Resume resume);
    Resume get(String uuid);
    Resume[] getAll();
    void update(Resume resume);
    void delete(String uuid);
    int size();

}
