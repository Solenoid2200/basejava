package ru.javawebinar.basejava.storage;

import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapUuidStorageTest extends AbstractStorageTest {

    public MapUuidStorageTest() {
        super(new MapUuidStorage());
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> allResumes = storage.getAllSorted();
        assertEquals(3, allResumes.size());
    }
}