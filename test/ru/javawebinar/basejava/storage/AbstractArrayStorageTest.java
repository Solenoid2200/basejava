package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    AbstractArrayStorageTest(Storage storage) {
        super(storage);
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
        storage.save(RESUME_0);
    }
}
