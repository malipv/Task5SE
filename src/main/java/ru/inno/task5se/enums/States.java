package ru.inno.task5se.enums;

public enum States {
    OPEN("Открыт"),
    CLOSED("Закрыт"),
    RESERVED("Зарезервирован"),
    DELETED("Удален");

    private String name;

    States(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}