package org.example;

public class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        if (name == null || name.isEmpty() || name.length() > 40) {
            throw new IllegalArgumentException("Name must be non-null, non-empty, and no longer than 40 characters.");
        }
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Age must be between 0 and 120.");
        }
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }


    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}
