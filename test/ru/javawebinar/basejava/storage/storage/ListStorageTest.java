package ru.javawebinar.basejava.storage.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.storage.ListStorage;

import java.util.ArrayList;
import java.util.List;

public class ListStorageTest extends AbstractStorageTest {
    public ListStorageTest() {
        super(new ListStorage());
    }

    @Test
    public void testGetAll() {
        List<Resume> expectedResumes = new ArrayList<>();
        expectedResumes.add(resume1);
        expectedResumes.add(resume2);
        expectedResumes.add(resume3);
        Assert.assertEquals(expectedResumes, storage.getAllFromList());
    }
}
