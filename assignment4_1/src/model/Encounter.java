/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lynn Wei
 */
public class Encounter extends VitalSigns{
    private String date;
  
    
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date = date;
    }
    
}
