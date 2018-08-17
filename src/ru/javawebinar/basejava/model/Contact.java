package ru.javawebinar.basejava.model;

public enum Contact {

    TELEFON ("Телефон"),
    EMAIL ("eMail"),
    SKYPE ("Skype"),
    HOMESITE ("Домашняя страница");

    private final String info;

    Contact(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "info='" + info + '\'' +
                '}';
    }

}
