package ru.example.sportevents.ui.main;

public class Event {
    private String name;
    private String description;
    private String city;

    public Event(String name, String description, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
