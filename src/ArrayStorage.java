import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    private Resume[] storage = new Resume[10000];
    private int size = 0;
    private int count = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        boolean isResumeExist = isResumeExist(resume);
        if(isResumeExist) {
            System.out.println("Resume exist!");
        }
        if(size > 9999) {
            System.out.println("Array is filled!");
        }
        if(!isResumeExist && size < 10000) {
            storage[size] = resume;
            size++;
        }
    }

    void update(Resume resume) {
        boolean isResumeExist = isResumeExist(resume);
        if(isResumeExist) {
            storage[count] = resume;
        } else {
            System.out.println("Resume not exist!");
        }
    }

    Resume get(String uuid) {
        boolean isResumeExist = isResumeExist(uuid);
        if(isResumeExist) {
            return storage[count];
        }
        System.out.println("Resume not exist!");
        return null;
    }

    void delete(String uuid) {
        boolean isResumeExist = isResumeExist(uuid);
        if (isResumeExist) {
            System.arraycopy(storage, count + 1, storage, count, size - count - 1);
            size--;
        } else {
            System.out.println("Resume not exist!");
        }
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

    private boolean isResumeExist (Resume resume) {
        boolean result = false;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(resume.uuid)) {
                count = i;
                result = true;
                break;
            }
        }
        return result;
    }

    private boolean isResumeExist (String incUuid) {
        Resume resume = new Resume();
        resume.uuid = incUuid;
        return isResumeExist (resume);
    }

}
