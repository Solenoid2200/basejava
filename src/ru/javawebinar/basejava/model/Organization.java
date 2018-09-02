package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class Organization {
    private final Link homePage;
    private final String title;
    private final List<OrganizationUnit> organizationUnits;

    public Organization(String name, String url, String title, List<OrganizationUnit> organizationUnits) {
        Objects.requireNonNull(title, "title must not be null");
        this.homePage = new Link(name, url);
        this.title = title;
        this.organizationUnits = organizationUnits;
    }

    // equals() & hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Organization)) return false;
        Organization that = (Organization) o;
        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(title, that.title) &&
                Objects.equals(organizationUnits, that.organizationUnits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, title, organizationUnits);
    }

    // toString()
    @Override
    public String toString() {
        return "Organization{" +
                "homePage=" + homePage +
                ", title='" + title + '\'' +
                ", organizationUnits=" + organizationUnits +
                '}';
    }
}
