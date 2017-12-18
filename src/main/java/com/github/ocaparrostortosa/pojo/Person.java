/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ocaparrostortosa.pojo;

/**
 * File to create Person POJO.
 * @author OSCAR
 */
public class Person {
    private String name;
    private String surname;
    private String gender;
    private String idNumber;
    
    public Person(){}

    public Person(String name, String surname, String gender, String idNumber) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getIdNumber() {
        return idNumber;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", surname=" + surname + ", gender=" + gender + ", idNumber=" + idNumber + '}';
    }
}