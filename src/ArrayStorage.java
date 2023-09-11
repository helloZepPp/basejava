/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {

        for (int i = 0; i < storage.length; i++) {

            if (size != 0 && storage[i] != null) {
                storage[i] = null;
                size--;
            }

        }

    }

    void save(Resume r) {

        for (int i = 0; i < storage.length; i++) {

            if (storage[i] == null) {
                storage[i] = r;
                size++;
                break;
            }

        }

    }

    Resume get(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].toString() == uuid) {
                return storage[i];
            }
        }

        return null;

    }

    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].toString() == uuid) {
                storage[i] = null;
                size--;
                break;
            }
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] vRes = new Resume[size()];

        for (int i = 0; i < size(); i++) {
            vRes[i] = storage[i];
        }

        return vRes;

    }

    int size() {
        return size;
    }

}
