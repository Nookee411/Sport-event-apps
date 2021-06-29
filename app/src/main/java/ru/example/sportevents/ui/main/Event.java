package ru.example.sportevents.ui.main;

public class Event {
    private String name;
    private String description;
    private String city;
    private final String hash;

    public Event(String name, String description, String city, String hash) {
        this.name = name;
        this.description = description;
        this.city = city;
        this.hash = hash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public String getHash() {
        return hash;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

