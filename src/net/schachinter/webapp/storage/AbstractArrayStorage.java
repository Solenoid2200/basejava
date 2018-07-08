package net.schachinter.webapp.storage;

import net.schachinter.webapp.model.Resume;

public abstract class AbstractArrayStorage implements Storage {

    protected final static int ARRAY_MAX_SIZE = 10000;
    protected Resume[] storage = new Resume[ARRAY_MAX_SIZE];
    protected int size = 0;

    public int size() {
        return size;
    }

}
