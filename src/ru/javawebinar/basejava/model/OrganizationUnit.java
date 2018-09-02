package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.util.Objects;

public class OrganizationUnit {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String description;

    public OrganizationUnit(LocalDate startDate, LocalDate endDate, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrganizationUnit)) return false;
        OrganizationUnit that = (OrganizationUnit) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, description);
    }

    // toString()
    @Override
    public String toString() {
        return "OrganizationUnit{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
