package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class ArrayStorageTest extends AbstractArrayStorageTest {
    public ArrayStorageTest() {
        super(new ArrayStorage());
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