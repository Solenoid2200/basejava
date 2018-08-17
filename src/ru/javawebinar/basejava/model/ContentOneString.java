package ru.javawebinar.basejava.model;

import java.util.Objects;

public class ContentOneString extends Content {

    private final String text;

    public ContentOneString(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentOneString)) return false;
        ContentOneString that = (ContentOneString) o;
        return Objects.equals(getText(), that.getText());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getText());
    }

    @Override
    public String toString() {
        return "ContentOneString{" +
                "text='" + text + '\'' +
                '}';
    }

}
