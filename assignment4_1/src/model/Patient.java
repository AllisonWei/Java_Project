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
public class Patient extends Person {
   
    private EncounterHistory encounterHistory;

    public EncounterHistory getEncounterHistory() {
        
        if(null!=encounterHistory){
            return encounterHistory;
        }else{
            encounterHistory=new EncounterHistory();
             return encounterHistory;
        }
        
    }

    public void setEncounterHistory(EncounterHistory encounterHistory) {
        this.encounterHistory = encounterHistory;
    }
    
    
}
