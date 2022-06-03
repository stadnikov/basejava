/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int counter = 0;
        while (storage[counter] != null) {
            storage[counter] = null;
            counter++;
        }
    }

    void save(Resume r) {
        int counter = 0;
        while (storage[counter] != null) {
            counter++;
        }
        storage[counter] = r;
    }

    Resume get(String uuid) {
        int counter = 0;
        while (storage[counter] != null) {
            if (storage[counter].uuid.equals(uuid)) {
                return storage[counter];
            }
            counter++;
        }
        return null;
    }

    void delete(String uuid) {
        int counter = 0;

        int itemToRemove = 0;

        while (storage[counter] != null) {
            if (storage[counter].uuid.equals(uuid)) {
                itemToRemove = counter;
            }
            counter++;
        }

        if (counter > 0) {
            storage[itemToRemove] = storage[counter - 1];
            storage[counter - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int counter = 0;
        while (storage[counter] != null) {
            counter++;
        }
        Resume[] tempResumeArray = new Resume[counter];
        System.arraycopy(storage, 0, tempResumeArray, 0, counter);
        return tempResumeArray;
    }

    int size() {
        int counter = 0;
        while (storage[counter] != null) {
            counter++;
        }
        return counter;
    }
}
