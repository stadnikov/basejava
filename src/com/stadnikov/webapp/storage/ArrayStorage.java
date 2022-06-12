package com.stadnikov.webapp.storage;

import com.stadnikov.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    public void clear() {
//        for (int i = 0; i < size; i++) {
        //          storage[i] = null;
        //    }
        Arrays.fill(storage, 0, size() - 1, null);
        size = 0;
    }

    public void update(Resume r) {
        if (get(r.getUuid()) != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(r.getUuid())) {
                    storage[i] = r;
                }
            }
        } else {
            System.out.println("Unable to update: There is no uuid = " + r.getUuid());
        }
    }

    public void save(Resume r) {
        if (size() < 10000) {
            if (get(r.getUuid()) == null) {
                storage[size] = r;
                size++;
            } else {
                System.out.println("Unable to save: There is already item with uuid = " + r.getUuid());
            }
        } else {
            System.out.println("Unable to save: Overflow of Storage, uuid = " + r.getUuid());
        }
    }

    public Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        System.out.println("Unable to get: There is no uuid = " + uuid);
        return null;
    }

    public void delete(String uuid) {
        if (get(uuid) != null) {
            for (int i = 0; i < size; i++) {
                if (storage[i].getUuid().equals(uuid)) {
                    size--;
                    storage[i] = storage[size];
                    storage[size] = null;
                }
            }
        } else {
            System.out.println("Unable to delete: There is no uuid = " + uuid);
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
