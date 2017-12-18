/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.ocaparrostortosa.dao;

import com.github.ocaparrostortosa.pojo.Person;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 *
 * @author OSCAR
 */
public class PersonDAO {
    
    private static Sheet sh; 
    private static String[] userParams = {"Name", "Surname", "Gender", "ID Number"};
    
    public void saveListInFile(List<Person> finalPersonList){
        
        SXSSFWorkbook wb = new SXSSFWorkbook();
               
        sh = wb.createSheet("PeopleGenerator");
        
        createFirstRow();
        
        for (int i = 1; i < finalPersonList.size(); i++) {
            Row row = sh.createRow(i);
            for (int j = 0; j < 4; j++) {
                Cell cell = row.createCell(j);
                switch(j){
                    case 0:
                        cell.setCellValue(String.valueOf(finalPersonList.get(i).getName()));
                        break;
                    case 1:
                        cell.setCellValue(String.valueOf(finalPersonList.get(i).getSurname()));
                        break;
                    case 2:
                        cell.setCellValue(String.valueOf(finalPersonList.get(i).getGender()));
                        break;
                    case 3:
                        cell.setCellValue(String.valueOf(finalPersonList.get(i).getIdNumber()));
                        break;
                    default:
                        cell.setCellValue("error");
                        break;
                }               
            }
        }
        
        try {
            FileOutputStream out = new FileOutputStream(System.getProperty("user.home") + "/Desktop/PeopleGenerator.xlsx");
            wb.write(out);
            System.out.println("The file 'PeopleGenerator.xlsx' was saved in your personal desktop");
            out.close();                        
        } catch (IOException ex) {
            // Logger.getLogger(HolaMundoExcel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR trying to create the excel file: "+
                    ex.getLocalizedMessage());
        } finally {
            wb.dispose();
        }
    }
    
    private static void createFirstRow(){
        Row firstRow = sh.createRow(0);
        for(int i = 0; i < 4; i++){
            Cell cell = firstRow.createCell(i);
            cell.setCellValue(userParams[i]);
        }
    }
    
}

