package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.exception.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;

public class ObjectStreamStorageSerializator implements Serializator {

    @Override
    public void doWrite(Resume r, OutputStream os) {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        } catch (IOException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }

    @Override
    public Resume doRead(InputStream is) {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        } catch (IOException e) {
            throw new StorageException("Error read resume", null, e);
        }
    }
}
