package net.schachinter.webapp.storage;

import net.schachinter.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class SortedArrayStorage extends AbstractArrayStorage {

    public void save(Resume r) {
        System.out.println(r.getUuid() + " ---------13 getIndex(r.getUuid()) = " + getIndex(r.getUuid()));
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Resume " + r.getUuid() + " already exist");
        } else if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else {
            if(size == 0) {
                storage[size] = r;
            }
            else {
                int insertIndex = 0;
                for (int i = 0; i < size; i++) {
                    if(storage[i].getUuid().compareTo(r.getUuid()) > 0) {
                        insertIndex = i;
                        break;
                    }
                }
                System.arraycopy(storage, insertIndex, storage, insertIndex+1, size-insertIndex);
                storage[insertIndex] = r;
            }
            size++;
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            System.arraycopy(storage, index+1, storage, index, size-index-1);
            storage[size - 1] = null;
            size--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}