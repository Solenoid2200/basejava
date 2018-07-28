package ru.javawebinar.basejava.storage.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.Storage;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {
    AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    public void testGetAll() {
        Resume[] expectedResumes = {resume1, resume2, resume3};
        Assert.assertArrayEquals(expectedResumes, storage.getAllFromArray());
    }
}
