package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentListOfFirms extends Content {

    private final List<OneFirma> firms = new ArrayList<>();

    public ContentListOfFirms() {
    }

    public List<OneFirma> getFirms() {
        return firms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentListOfFirms)) return false;
        ContentListOfFirms that = (ContentListOfFirms) o;
        return Objects.equals(getFirms(), that.getFirms());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getFirms());
    }

    @Override
    public String toString() {
        return "ContentListOfFirms{" +
                "firms=" + firms +
                '}';
    }

}
