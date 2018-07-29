package ru.javawebinar.basejava.storage;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorageTest {
    Storage storage;
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String UUID_0 = "uuid0";
    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);
    static final Resume RESUME_0 = new Resume(UUID_0);

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @After
    public void tearDown() {
        storage.clear();
    }

    // save()
    @Test
    public void testSave() {
        storage.save(RESUME_4);
        Assert.assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test
    public void testSaveSize() {
        storage.save(RESUME_4);
        Assert.assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void testSaveExistStorageException() {
        storage.save(RESUME_3);
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
        Assert.assertEquals(RESUME_1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void testGetNotExistStorageException() {
        storage.get(UUID_4);
    }

    // getAll()
    @Test
    public void testGetAll() {
        Resume[] array = storage.getAll();
        Assert.assertEquals(3, array.length);
        Assert.assertEquals(RESUME_1, array[0]);
        Assert.assertEquals(RESUME_2, array[1]);
        Assert.assertEquals(RESUME_3, array[2]);
    }

    // size()
    @Test
    public void testSize() {
        Assert.assertEquals(3, storage.size());
    }
}
