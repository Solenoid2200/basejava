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
        if(isResumeExist(resume.uuid)) {
            System.out.println("Resume exist!");
            return;
        }
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        if(isResumeExist(uuid)) {
            return storage[findResumeNumber(uuid)];
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
        if(isResumeExist(resume.uuid)) {
            storage[findResumeNumber(resume.uuid)] = resume;
            return;
        }
        System.out.println("Resume not exist!");
    }

    void delete(String uuid) {
        if(isResumeExist(uuid)) {
            int i = findResumeNumber(uuid);
            storage[i] = storage[size-1];
            storage[size-1] = null;
            size--;
            return;
        }
        System.out.println("Resume not exist!");
    }

    int size() {
        return size;
    }

    private boolean isResumeExist (String incUuid) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(incUuid)) {
                result = true;
                break;
            }
        }
        return result;
    }

    private int findResumeNumber (String incUuid) {
        int result = 0;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(incUuid)) {
                result = i;
                break;
            }
        }
        return result;
    }

}
