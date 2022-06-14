package com.stadnikov.webapp.storage;

import com.stadnikov.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void clear() {
//        for (int i = 0; i < size; i++) {
        //          storage[i] = null;
        //    }
        Arrays.fill(storage, 0, size(), null);
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            System.out.println("Unable to update: There is no item with uuid = " + r.getUuid());
        } else {
            storage[index] = r;
        }
    }

    public void save(Resume r) {
        if (getIndex(r.getUuid()) != -1) {
            System.out.println("Unable to save: There is already item with uuid = " + r.getUuid());
        } else {
            if (size() == STORAGE_LIMIT) {
                System.out.println("Unable to save: Overflow of Storage, uuid = " + r.getUuid());
            } else {
                storage[size] = r;
                size++;
            }
        }
    }



    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Unable to delete: There is no uuid = " + uuid);
        } else {
            size--;
            storage[index] = storage[size];
            storage[size] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return size;
            }
        }
        return -1;
    }
}
