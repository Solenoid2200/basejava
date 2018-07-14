package net.schachinter.webapp.storage;

import net.schachinter.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void saveIndex(Resume r, int index) {
        int insertIndex = (-index) - 1;
        System.arraycopy(storage, insertIndex, storage, insertIndex + 1, size - insertIndex);
        storage[insertIndex] = r;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void deleteIndex(int index) {
        if (size > 1 && index < STORAGE_LIMIT-1) {
            System.arraycopy(storage, index + 1, storage, index, size - index - 1);
        }
    }
}