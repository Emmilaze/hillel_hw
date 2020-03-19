package com.hillel.webapp.filmlibrary.person;

import java.util.Date;

public abstract class Person {
    private int id;
    private String name;
    private Date birth;

    public Person(int id, String name, Date birth) {
        this.id = id;
        this.name = name;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }

    @Override
    public String toString() {
        return "\n№" + id + ", name: " + name + ", birth: " + birth;
    }
}