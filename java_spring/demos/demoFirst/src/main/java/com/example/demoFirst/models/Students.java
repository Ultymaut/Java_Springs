package com.example.demoFirst.models;

public class Students {

    private int id;
    private String lastName;
    private String firstName;
    private Integer age;
    private static int nbStudents = 0;

    public Students(String lastName, String firstName, Integer age) {
        this.id = nbStudents++;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
