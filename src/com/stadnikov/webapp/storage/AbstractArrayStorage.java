package com.stadnikov.webapp.storage;

import com.stadnikov.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("Unable to get: There is no uuid = " + uuid);
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

}
