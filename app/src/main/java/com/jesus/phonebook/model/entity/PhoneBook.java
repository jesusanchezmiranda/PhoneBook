package com.jesus.phonebook.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "phoneBook")
public class PhoneBook {

    public PhoneBook() {
    }

    public PhoneBook(@NonNull String name, @NonNull String surname, @NonNull String phone, @NonNull String birthdate, @NonNull String location, @NonNull String street, String number) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.birthdate = birthdate;
        this.location = location;
        this.street = street;
        this.number = number;
    }

    @PrimaryKey(autoGenerate = true)
    private long id;

    @NonNull
    @ColumnInfo(name = "name")
    private String name;

    @NonNull
    @ColumnInfo(name = "surname")
    private String surname;

    @NonNull
    @ColumnInfo(name = "phone")
    private String phone;

    @NonNull
    @ColumnInfo(name = "birthday")
    private String birthdate;

    @NonNull
    @ColumnInfo(name = "location")
    private String location;

    @NonNull
    @ColumnInfo(name = "street")
    private String street;

    @NonNull
    @ColumnInfo(name = "number")
    private String number;

    @Override
    public String toString() {
        return "PhoneBook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", location='" + location + '\'' +
                ", street='" + street + '\'' +
                ", number=" + number +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    @NonNull
    public String getPhone() {
        return phone;
    }

    public void setPhone(@NonNull String phone) {
        this.phone = phone;
    }

    @NonNull
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(@NonNull String birthdate) {
        this.birthdate = birthdate;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    public void setLocation(@NonNull String location) {
        this.location = location;
    }

    @NonNull
    public String getStreet() {
        return street;
    }

    public void setStreet(@NonNull String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
