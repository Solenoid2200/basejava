package ru.javawebinar.basejava.app;

import ru.javawebinar.basejava.model.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Resume resume = new Resume("uuid1", "Ivanov");

        resume.getContacts().put(ContactType.PHONE, "32223332323");
        resume.getContacts().put(ContactType.SKYPE, "IvanovSkype");
        resume.getContacts().put(ContactType.MAIL, "ivanov@mail.ru");

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

        List<Organization> educations = new ArrayList<>();
        LocalDate startDate = LocalDate.of(2018, Month.JUNE, 26);
        LocalDate endDate = LocalDate.of(2018, Month.DECEMBER, 26);
        educations.add(new Organization("JavaOPs", "http://javaops.ru/",
                "JavaKurs", new ArrayList<OrganizationUnit>()));
        resume.getSections().put(SectionType.EDUCATION, new OrganizationSection(educations));

        List<Organization> experiences = new ArrayList<>();
        LocalDate startDateExperiences = LocalDate.of(2017, Month.JUNE, 26);
        LocalDate endDateExperiences = LocalDate.of(2017, Month.DECEMBER, 26);
        experiences.add(new Organization("Job", "http://ivanov-job-java.ru/",
                "Job1", new ArrayList<OrganizationUnit>()));
        resume.getSections().put(SectionType.EXPERIENCE, new OrganizationSection(experiences));
    }
}
