package org.meow.meow.models;

import org.meow.meow.models.enums.Gender;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import static org.meow.meow.models.validation.ValidationConstants.*;

public class AdoptionCat {
    @Size(min=NAME_MIN, max=NAME_MAX)
    private String name;
    @Min(AGE_MIN)
    @Max(AGE_MAX)
    private int age;
    private String gender;
    @Size(min=TOWN_MIN, max=TOWN_MAX)
    private String town;
    @Size(max=DESCRIPTION_MAX)
    private String description;
    private String imageHash;
    // TODO - Custom validation
    private String organization;

    public AdoptionCat(String name, int age, String gender,
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

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
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