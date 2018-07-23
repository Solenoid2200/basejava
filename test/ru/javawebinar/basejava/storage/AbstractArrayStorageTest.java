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
    private Storage storage = new ArrayStorage();
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    Resume resume4 = new  Resume(UUID_4);

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void clearSizeTest() {
        storage.clear();
        Assert.assertTrue(0 == storage.size());
    }

    @Test
    public void updateExistResumeTest() {
        storage.update(new Resume(UUID_3));
        Assert.assertEquals(UUID_3, storage.get("uuid3").getUuid());
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistResumeTest() throws Exception {
        storage.update(new Resume(UUID_4));
    }

    @Test
    public void getAllTest() {
        Resume[] tmp = new Resume[3];
        tmp[0] = new Resume(UUID_1);
        tmp[1] = new Resume(UUID_2);
        tmp[2] = new Resume(UUID_3);
        Assert.assertEquals(tmp, storage.getAll());
    }

    @Test(expected = ExistStorageException.class)
    public void saveIndexExistTest() throws Exception {
        Resume r = new  Resume(UUID_3);
        storage.save(r);
    }

    @Test
    public void saveStorageOverflowTest() {
        try {
            storage.save(resume4);
        } catch (Exception e) {
            Assert.fail();
        }
        storage.size = 999;
        if(storage.size == 9999) {
            throw new StorageException("", UUID_4);
        }
    }

    @Test
    public void saveTest() {
        storage.save(resume4);
        Assert.assertEquals(resume4, storage.storage[3]);
    }

    @Test
    public void saveSizeTest() {
        storage.save(resume4);
        Assert.assertTrue(4 == storage.size);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistStorageExceptionTest() throws Exception {
        storage.delete(UUID_4);
    }

    @Test
    public void deleteNullTest() {
        storage.delete(UUID_1);
        Assert.assertTrue(null == storage.storage[2]);
    }

    @Test
    public void deleteSizeTest() {
        storage.delete(UUID_3);
        Assert.assertTrue(2 == storage.size);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExistStorageExceptionTest() throws Exception {
        storage.get(UUID_4);
    }

    @Test
    public void getTest() {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    protected abstract void fillDeletedElementTest(int index);

    protected abstract void insertElementTest(Resume r, int index);

    protected abstract int getIndexTest(String uuid);

}