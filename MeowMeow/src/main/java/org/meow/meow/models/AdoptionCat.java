package org.meow.meow.models;

import org.meow.meow.models.enums.Gender;

public class AdoptionCat {
    private String name;
    private int age;
    private Gender gender;
    private String town;
    private String description;
    private String imageHash;
    private String organization;

    public AdoptionCat(String name, int age, Gender gender,
                       String town, String description, String imageHash, String organization) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.town = town;
        this.description = description;
        this.imageHash = imageHash;
        this.organization = organization;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageHash() {
        return this.imageHash;
    }

    public void setImageHash(String imageHash) {
        this.imageHash = imageHash;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }
}