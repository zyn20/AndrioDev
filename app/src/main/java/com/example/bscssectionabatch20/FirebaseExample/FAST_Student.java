package com.example.bscssectionabatch20.FirebaseExample;

public class FAST_Student {
    String Id,Name,City;

    public FAST_Student(String id, String name, String city) {
        Id = id;
        Name = name;
        City = city;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }
}
