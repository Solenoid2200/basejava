package ru.javawebinar.basejava.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ContentListOfString extends Content {

    private final List<String> contentList = new ArrayList<>();

    public ContentListOfString() {
    }

    public List<String> getContentList() {
        return contentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentListOfString)) return false;
        ContentListOfString that = (ContentListOfString) o;
        return Objects.equals(getContentList(), that.getContentList());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getContentList());
    }

    @Override
    public String toString() {
        return "ContentListOfString{" +
                "contentList=" + contentList +
                '}';
    }

}
