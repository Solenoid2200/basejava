package ru.javawebinar.basejava.storage;

import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exception.ExistStorageException;
import ru.javawebinar.basejava.exception.NotExistStorageException;
import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public abstract class AbstractStorageTest {
    Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1;
    private static final Resume RESUME_2;
    private static final Resume RESUME_3;
    private static final Resume RESUME_4;

    static {
        RESUME_1 = new Resume(UUID_1, "Name1");
        RESUME_2 = new Resume(UUID_2, "Name2");
        RESUME_3 = new Resume(UUID_3, "Name3");
        RESUME_4 = new Resume(UUID_4, "Name4");
        fillResume();
    }

    private static void fillResume() {
        Resume resume = new Resume("uuid5", "Ivanov");
        // Fill contacts
        resume.getContacts().put(ContactType.PHONE, "32223332323");
        resume.getContacts().put(ContactType.SKYPE, "IvanovSkype");
        resume.getContacts().put(ContactType.MAIL, "ivanov@mail.ru");

        // Fill sections
        resume.getSections().put(SectionType.PERSONAL, new TextSection("Целеустремлённый"));
        resume.getSections().put(SectionType.OBJECTIVE, new TextSection("Изучаю Java"));

        List<String> itemsAchievement = new ArrayList<>();
        itemsAchievement.add("Достижение1");
        itemsAchievement.add("Достижение2");
        resume.getSections().put(SectionType.ACHIEVEMENT, new ListSection(itemsAchievement));

        List<String> itemsQualifications = new ArrayList<>();
        itemsQualifications.add("Квалификация1");
        itemsQualifications.add("Квалификация2");
        resume.getSections().put(SectionType.QUALIFICATIONS, new ListSection(itemsQualifications));

        LocalDate startDate = LocalDate.of(2018, Month.JUNE, 26);
        LocalDate endDate = LocalDate.of(2018, Month.DECEMBER, 26);
        String title = "Title";
        String description = "Kislin-kurs";
        OrganizationUnit organizationUnit = new OrganizationUnit(startDate, endDate, title, description);
        List<OrganizationUnit> organizationUnits = new ArrayList<>();
        organizationUnits.add(organizationUnit);
        List<Organization> educations = new ArrayList<>();
        educations.add(new Organization("JavaOPs", "http://javaops.ru/",
                "JavaKurs", organizationUnits));
        resume.getSections().put(SectionType.EDUCATION, new OrganizationSection(educations));

        startDate = LocalDate.of(2017, Month.JUNE, 26);
        endDate = LocalDate.of(2017, Month.DECEMBER, 26);
        description = "JavaRush";
        organizationUnit = new OrganizationUnit(startDate, endDate, title, description);
        organizationUnits.add(organizationUnit);
        List<Organization> experiences = new ArrayList<>();
        educations.add(new Organization("JavaRush", "http://javarush.ru/",
                "JavaKurs", organizationUnits));
        resume.getSections().put(SectionType.EDUCATION, new OrganizationSection(educations));
        resume.getSections().put(SectionType.EXPERIENCE, new OrganizationSection(experiences));

    }

    AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "New Name");
        storage.update(newResume);
        assertSame(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAllSorted() {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(RESUME_1, RESUME_2, RESUME_3));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete("dummy");
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("dummy");
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}