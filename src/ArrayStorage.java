import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        if(size > storage.length-1) {
            System.out.println("Array is filled!");
            return;
        }
        if(findResumeNumber(resume.uuid) !=-1) {
            System.out.println("Resume exist!");
            return;
        }
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        int count = findResumeNumber(uuid);
        if(count !=-1) {
            return storage[count];
        }
        System.out.println("Resume not exist!");
        return null;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    void update(Resume resume) {
        int count = findResumeNumber(resume.uuid);
        if(count !=-1) {
            storage[count] = resume;
            return;
        }
        System.out.println("Resume not exist!");
    }

    void delete(String uuid) {
        int count = findResumeNumber(uuid);
        if(count !=-1) {
            storage[count] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            return;
        }
        System.out.println("Resume not exist!");
    }

    int size() {
        return size;
    }

    private int findResumeNumber(String incUuid) {
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(incUuid)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
