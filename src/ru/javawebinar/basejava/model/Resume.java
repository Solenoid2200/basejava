package ru.javawebinar.basejava.model;

import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    // Getters
    public String getUuid() {
        return uuid;
    }

    public String getFullName() {
        return fullName;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Resume)) return false;
        Resume resume = (Resume) o;
        return Objects.equals(uuid, resume.getUuid()) &&
                Objects.equals(fullName, resume.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, fullName);
    }

    // toString()
    @Override
    public String toString() {
        return "Resume{" +
                "uuid='" + uuid + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Resume resume) {
        int result = fullName.compareTo(resume.fullName);
        return result !=0 ? result : uuid.compareTo(resume.uuid);
    }

}
