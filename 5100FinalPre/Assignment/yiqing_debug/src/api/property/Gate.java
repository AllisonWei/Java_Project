/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.property;

/**
 *
 * @author 10857
 */
public class Gate {
    private int number;
    private String Status;

    public Gate(int number, String Status) {
        this.number = number;
        this.Status = Status;
    }
    
    

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    @Override
    public String toString(){
        return String.valueOf(this.number);
    }
    
    
}
