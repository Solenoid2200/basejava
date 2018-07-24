package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private Resume resume4 = new Resume(UUID_4);

    AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void testSetUp() {
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @After
    public void testTearDown() {
        storage.clear();
    }

    @Test
    public void testSize() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void testClear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void testUpdate() {
        storage.update(new Resume(UUID_3));
        Assert.assertEquals(UUID_3, storage.get(UUID_3).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void testUpdateNotExistStorageException() {
        storage.update(new Resume(UUID_4));
    }

    @Test
    public void testGetAll() {
        Resume[] tmp = new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};
        Assert.assertArrayEquals(tmp, storage.getAll());
    }

    @Test
    public void testSave() {
        storage.save(resume4);
        Assert.assertEquals(resume4, storage.get(UUID_4));
    }

    @Test
    public void testSaveSize() {
        storage.save(resume4);
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void testSaveIndexExist() {
        Resume resume = new Resume(UUID_3);
        storage.save(resume);
    }

    @Test(expected = StorageException.class)
    public void testSaveStorageException() {
        try {
            storage.save(resume4);
        } catch (Exception e) {
            Assert.fail();
        }
        for (int i = 4; i < AbstractArrayStorage.STORAGE_LIMIT + 1; i++) {
            storage.save(new Resume("uuid" + i));
        }
        storage.save(resume4);
    }

    @Test
    public void testDeleteSize() {
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void testDeleteNotExistStorageException() {
        storage.delete(UUID_4);
    }

    @Test
    public void testGet() {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void testGetNotExistStorageException() {
        storage.get(UUID_4);
    }
}