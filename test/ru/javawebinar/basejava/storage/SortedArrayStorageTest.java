package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {
    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Override
    protected void fillDeletedElementTest(int index) {

    }

    @Override
    protected void insertElementTest(Resume r, int index) {

    }

    @Override
    protected int getIndexTest(String uuid) {
        return 0;
    }
}