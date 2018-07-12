package net.schachinter.webapp.model;

/**
 * Resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private String uuid;

    @Override
    public int compareTo(Resume resume) {
        return uuid.compareTo(resume.uuid);
    }

    // Getters & setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid);
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    // toString()
    @Override
    public String toString() {
        return uuid;
    }

}
