package ru.javawebinar.basejava.model;

import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

public class Resume implements Comparable<Resume> {

    private final String uuid;
    private final String fullName;
    private final Map<Contact, String> contactMap = new EnumMap<Contact, String>(Contact.class);
    private final Map<Section, Content> sectionMap = new EnumMap<Section, Content>(Section.class);


    // Constructors
    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
        this.fullName = "Dummy";
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }

    // Get-methods
    public String getContact(Contact contact) {
        return contactMap.get(contact);
    }

    public Content getSection(Section section) {
        return sectionMap.get(section);
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
        return Objects.equals(getUuid(), resume.getUuid()) &&
                Objects.equals(getFullName(), resume.getFullName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUuid(), getFullName());
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
        if(result != 0) {
            return result;
        }
        return uuid.compareTo(resume.uuid);
    }

}
