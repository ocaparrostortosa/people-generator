/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ocaparrostortosa.controller;

import com.github.ocaparrostortosa.dao.PersonDAO;
import com.github.ocaparrostortosa.pojo.People;
import com.github.ocaparrostortosa.pojo.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author OSCAR
 */
public class Controller {
    
    private PersonDAO personDao = new PersonDAO();
    private static final String[] maleNamesList = {"Alden", "Alfred", "Arthur", "Blake", "Bradley", "Brandom", "Carter", "Cody", "Tyler", "William"};
    private static final String[] femaleNamesList = {"Evelyn", "Hailey", "Gracie", "Kimberly", "Lauren", "Scarlett", "Chelsea", "Carol", "Katie", "Joanna"};
    private static final String[] surnames = {"Brown", "Smith", "Jones", "Williams", "Johnson", "Lewis", "Phillips", "Wilson", "Rose", "Mitchell",};
    public static final String NIF_STRING_ASOCIATION = "TRWAGMYFPDXBNJZSQVHLCKE";    
    private int numberOfPeople;
    private List<Person> finalPeopleList = null;
    private People people;
    
    public Controller(PersonDAO personDao, int numberOfPeople){
        this.personDao = personDao;
        this.numberOfPeople = numberOfPeople;
        this.finalPeopleList = generateListOfPeople();
        personDao.saveListInFile(finalPeopleList);
    }    
    
    public Controller(PersonDAO personDao){
        this.personDao = personDao;
        this.numberOfPeople = 100;
        this.finalPeopleList = generateListOfPeople();
        personDao.saveListInFile(finalPeopleList);
    }   
    
    private List<Person> generateListOfPeople(){
        people = new People();
        finalPeopleList = people.getPersonList();
        
        if(finalPeopleList != null){
             if(numberOfPeople != 0 && numberOfPeople > 0){
                 while(finalPeopleList.size() <= numberOfPeople){
                     int genderRandomNumber = generateRandomNumber(0,2);
                     int nameRandomNumber = generateRandomNumber(0,9);
                     int surnameRandomNumber = generateRandomNumber(0,9);
                     addNewPersonToList(genderRandomNumber, nameRandomNumber, surnameRandomNumber);
                 }                     
             }else{
                 System.out.println("Controller;generateListOfPeople:finalPeopleList:numberOfPeople != 0 || numberOfPeople < 0");
                 numberOfPeople = 100;
                 generateListOfPeople();
             }
        }else{
            System.out.println("Controller;generateListOfPeople:finalPeopleList == null");
            System.exit(1);
        }
        
        return finalPeopleList;
    }
    
    private void addNewPersonToList(int genderRandomNumber, int nameRandomNumber, int surnameRandomNumber){
        String gender = "";
        String name = "";
        String idNumber = "";
        String surname = "";
        
        switch(genderRandomNumber){
            case 1:
                gender = "Male";
                name = maleNamesList[nameRandomNumber];
                surname = surnames[surnameRandomNumber];
                idNumber = generateRandomIdNumber();
                break;
            case 2:
                gender = "Female";
                name = femaleNamesList[nameRandomNumber];
                surname = surnames[surnameRandomNumber];
                idNumber = generateRandomIdNumber();
                break;
            default:
                break;
        }
        
        
        finalPeopleList.add(new Person(name, surname, gender, idNumber));
    } 
    
    private int generateRandomNumber(int upperNumber, int lowerNumber){
        
        return (int) (Math.random() * (upperNumber - lowerNumber)) + lowerNumber;
    }
    
    private String generateRandomIdNumber(){
        int idNumber = (int) (Math.random() * 99999999);
        int idNumberLength = String.valueOf(idNumber).length();
        String finalIdNumber = String.valueOf(idNumber);
        //Checking if the length of the idNumber is lower than 8 to append '0' if it isn't.
        if(String.valueOf(idNumber).length() < 8){
            for(int i = idNumberLength; i < 8; i++){
                finalIdNumber = "0" + finalIdNumber;
            }
        }
        String idLetter = getIdLetter(idNumber);
        return finalIdNumber + idLetter ;
    }
    
    private String getIdLetter(int idNumber){        
        return "" + NIF_STRING_ASOCIATION.charAt(idNumber % 23);
    }
    
    public static void main(String args[]){
        new People();
    }
}
