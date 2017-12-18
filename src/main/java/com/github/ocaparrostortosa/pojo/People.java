/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ocaparrostortosa.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OSCAR
 */
public class People {
    private List<Person> personList;
    
    public People(){
        this.personList = new ArrayList<>();
    }
    
    public void addPersonToPeopleList(Person person){
        this.personList.add(person);
    }

    public List<Person> getPersonList() {
        return this.personList;
    }    
    
}