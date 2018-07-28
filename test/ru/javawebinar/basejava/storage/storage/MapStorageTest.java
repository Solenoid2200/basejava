package ru.javawebinar.basejava.storage.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.MapStorage;

import java.util.HashMap;
import java.util.Map;

public class MapStorageTest extends AbstractStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }

    @Test
    public void testGetAll() {
        Map<String, Resume> expectedResumes = new HashMap<>();
        expectedResumes.put(UUID_1, resume1);
        expectedResumes.put(UUID_2, resume2);
        expectedResumes.put(UUID_3, resume3);
        Assert.assertEquals(expectedResumes, storage.getAllFromMap());
    }
}
