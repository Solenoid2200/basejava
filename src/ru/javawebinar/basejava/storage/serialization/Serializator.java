package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.Resume;

import java.io.InputStream;
import java.io.OutputStream;

public interface Serializator {

    void doWrite(Resume r, OutputStream os);

    Resume doRead(InputStream is);

}
