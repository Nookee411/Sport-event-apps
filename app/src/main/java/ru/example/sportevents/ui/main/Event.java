package ru.example.sportevents.ui.main;

import lombok.Data;

@Data
public class Event {

    private String name;
    private String description;
    private String city;

    public Event(String name, String description, String city) {
        this.name = name;
        this.description = description;
        this.city = city;
    }

}
