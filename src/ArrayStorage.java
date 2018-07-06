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
        if(size > 9999) {
            System.out.println("Array is filled!");
            return;
        }
        for (int i = 0; i < size; i++) {
            if(resume.equals(storage[i])) {
                System.out.println("Resume exist!");
                return;
            }
        }
        storage[size] = resume;
        size++;
    }

    void update(Resume resume) {
        for (int i = 0; i < size; i++) {
            if(resume.equals(storage[i])) {
                storage[i] = resume;
                return;
            }
        }
        System.out.println("Resume not exist!");
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if(uuid.equals(storage[i].uuid)) {
                return storage[i] ;
            }
        }
        System.out.println("Resume not exist!");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size; i++) {
            if(uuid.equals(storage[i].uuid)) {
                storage[i] = storage[size-1];
                storage[size-1] = null;
                size--;
                return;
            }
        }
        System.out.println("Resume not exist!");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    int size() {
        return size;
    }

}
