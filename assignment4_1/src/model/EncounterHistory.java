/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lynn Wei
 */
public class EncounterHistory {
    
    private List<Encounter>  Encounters;

    public List<Encounter> getEncounters() {
        if(null!=Encounters){
            return Encounters;
        }else{
            Encounters=new ArrayList();
             return Encounters;
        }
    }

    public void setEncounters(List<Encounter> Encounters) {
        this.Encounters = Encounters;
    }
    
    
}
