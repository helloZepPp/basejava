import java.util.ArrayList;
import java.util.List;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];


    void clear() {

        for (int i = 0; i < storage.length; i++) {

            if (storage[i] != null) {
    	        storage[i] = null;
    		}

    	}

    }



    void save(Resume r) {

        for (int i = 0; i < storage.length; i++) {

            if (storage[i] == null) {
    	        storage[i] = r;
    	        break;
    		}

    	}

    }



    Resume get(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].toString() == uuid) {return storage[i];}
        }

    	return null;

    }



    void delete(String uuid) {

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null && storage[i].toString() == uuid) {storage[i] = null; break;}
        }

    }



    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
    // https://stackoverflow.com/questions/4150233/remove-null-value-from-string-array-in-java

        List<Resume> list = new ArrayList<Resume>();

        for(Resume r : storage) {
           if(r != null && storage.length > 0) {
              list.add(r);
           }
        }

        Resume[] v_res = list.toArray(new Resume[list.size()]);

    	return v_res;

    }



    int size() {
        int v_res = 0;

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {v_res++;}
        }

        return v_res;
    }

}