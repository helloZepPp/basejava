/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        size = 0;
    }

    void save(Resume r) {
        size++;
        storage = getAll();
        storage[size - 1] = r;
    }

    Resume get(String uuid) {
        storage = getAll();
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        storage = getAll();
        for (int i = 0; i < size; i++) {
            if (storage[i].toString() == uuid) {
                storage[i] = null;
                size--;
                break;
            }
        }
        storage = getAll();
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        int counter = 0;
        for (int i = 0; i < storage.length; i++) {
            if (counter >= size) {
                break;
            }
            if (storage[i] != null && storage[i].toString() != null) {
                resumes[counter] = storage[i];
                counter++;
            }
        }
        return resumes;
    }

    int size() {
        return size;
    }
}
