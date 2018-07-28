package ru.javawebinar.basejava.storage.storage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.AbstractArrayStorage;
import ru.javawebinar.basejava.storage.Storage;

public abstract class AbstractStorageTest {
    Storage storage;
    static final String UUID_1 = "uuid1";
    static final String UUID_2 = "uuid2";
    static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_0 = "uuid0";
    Resume resume1 = new Resume(UUID_1);
    Resume resume2 = new Resume(UUID_2);
    Resume resume3 = new Resume(UUID_3);
    private Resume resume4 = new Resume(UUID_4);
    private Resume resume0 = new Resume(UUID_0);

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.save(resume1);
        storage.save(resume2);
        storage.save(resume3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    // save()
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
    public void testSaveExistStorageException() {
        Resume resume = new Resume(UUID_3);
        storage.save(resume);
    }

    @Test(expected = StorageException.class)
    public void testSaveStorageException() {
        try {
            for (int i = 4; i < AbstractArrayStorage.STORAGE_LIMIT + 1; i++) {
                storage.save(new Resume("uuid" + i));
            }
        } catch (Exception e) {
            Assert.fail();
        }
        storage.save(resume0);
    }

    // update()
    @Test
    public void testUpdate() {
        storage.update(new Resume(UUID_3));
        Assert.assertEquals(UUID_3, storage.get(UUID_3).getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void testUpdateNotExistStorageException() {
        storage.update(new Resume(UUID_4));
    }

    // delete()
    @Test
    public void testDeleteSize() {
        storage.delete(UUID_3);
        Assert.assertEquals(2, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void testDeleteNotExistStorageException() {
        storage.delete(UUID_4);
    }

    // clear()
    @Test
    public void testClear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    // get()
    @Test
    public void testGet() {
        Assert.assertEquals(resume1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void testGetNotExistStorageException() {
        storage.get(UUID_4);
    }

    // getAll()
    @Test
    public abstract void testGetAll();

    // size()
    @Test
    public void testSize() {
        Assert.assertEquals(3, storage.size());
    }
}
