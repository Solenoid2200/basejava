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

                storage[i] = null;

                for (int j = i; j < storageCount; j++) {
                    storage[j] = storage[j+1];
                }

                storageCount--;
                break;

            }
        }
    }


    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] result;
        result = Arrays.copyOfRange(storage, 0, storageCount);
        return result;
    }


    int size() {
        return storageCount;
    }

}
