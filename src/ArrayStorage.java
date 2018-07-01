import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int storageCount = 0;


    void clear() {
        Arrays.fill(storage, 0, storageCount, null);
        storageCount = 0;
    }


    void save(Resume r) {
        storage[storageCount] = r;
        storageCount++;
    }


    Resume get(String uuid) {
        for (int i = 0; i < storageCount; i++) {
            if(storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }


    void delete(String uuid) {
        for (int i = 0; i < storageCount; i++) {
            if(storage[i].uuid.equals(uuid)) {
                System.arraycopy(storage, i + 1, storage, i, storageCount - i - 1);
                storageCount--;
                break;
            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, storageCount);
    }


    int size() {
        return storageCount;
    }

}
