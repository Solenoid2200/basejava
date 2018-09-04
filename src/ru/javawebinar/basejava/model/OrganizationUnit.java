package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class OrganizationUnit {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String title;
    private final String description;


    public OrganizationUnit(LocalDate startDate, LocalDate endDate, String description, String title) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    // Getters & setters
    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationUnit)) return false;
        OrganizationUnit that = (OrganizationUnit) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, title, description);
    }

    // toString()
    @Override
    public String toString() {
        return "OrganizationUnit{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
