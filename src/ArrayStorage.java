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

    	/* сначала нашел такое решение, но потом прочитал в ТЗ, что так нельзя
        List<Resume> list = new ArrayList<Resume>();
        for(Resume r : storage) {
           if(r != null && storage.length > 0) {list.add(r);}
        }
        Resume[] v_res = list.toArray(new Resume[list.size()]);
        */

        int v_size  = 0; // кол-во непустых элементов массива storage
        int v_count = 0; // счетчик для нового массива

        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {v_size++;}
        }

        Resume[] v_res = new Resume[v_size];


        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null) {
            	v_res[v_count] = storage[i]; v_count++;
            }
        }

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
