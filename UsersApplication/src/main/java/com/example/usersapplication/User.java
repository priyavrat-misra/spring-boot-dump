package com.example.usersapplication;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

public class User {
    @NotEmpty
    private String name;
    @Positive
    private int age;
    static int id = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    User(String name, int age) {
        ++id;
        this.name = name;
        this.age = age;
    }
}
