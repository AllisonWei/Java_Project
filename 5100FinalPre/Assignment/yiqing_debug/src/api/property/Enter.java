/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.property;

/**
 *
 * @author 10857
 */
public class Enter {
    private int enterNumber;
    private String status;

    public Enter(int enterNumber, String status) {
        this.enterNumber = enterNumber;
        this.status = status;
    }
    
    

    public int getEnterNumber() {
        return enterNumber;
    }

    public void setEnterNumber(int enterNumber) {
        this.enterNumber = enterNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.enterNumber);
    }
    
}
