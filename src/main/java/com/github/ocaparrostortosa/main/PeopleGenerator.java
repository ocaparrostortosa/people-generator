/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ocaparrostortosa.main;

import com.github.ocaparrostortosa.controller.Controller;
import com.github.ocaparrostortosa.dao.PersonDAO;
import java.util.Scanner;

/**
 *
 * @author OSCAR
 */
public class PeopleGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Enter the number of the people you want to create (Min. 1, Max. 100000):");
        Scanner sc = new Scanner(System.in);
        try{
            int number = sc.nextInt();
            sc.close();
            if(number > 0 && number < 100001){
                new Controller( new PersonDAO() , number);
            }else{
                throw new Exception();
            }
        }catch(Exception ex){
            System.out.println("Invalid number, the programm will close.");
            
        }
    }
    
}
