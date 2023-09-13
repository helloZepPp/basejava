import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        for (int i = 0; i < size; i++) {
            storage[i] = null;
        }
        size = 0;
    }

    void save(Resume r) {
        storage[size] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] beforStorage;
        Resume[] afterStorage;
        Resume[] resumes;
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                beforStorage = Arrays.copyOfRange(storage, 0, i);
                afterStorage = Arrays.copyOfRange(storage, i + 1, storage.length);
                resumes = Arrays.copyOf(beforStorage, storage.length);
                System.arraycopy(afterStorage, 0, resumes, beforStorage.length, afterStorage.length);
                size--;
                storage = resumes;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = Arrays.copyOf(storage, size);
        return resumes;
    }

    int size() {
        return size;
    }
}
