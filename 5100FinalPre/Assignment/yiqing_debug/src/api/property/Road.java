/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.property;

/**
 *
 * @author 10857
 */
public class Road {
    private int roadNumber;
    private String status;

    public Road(int roadNumber, String status) {
        this.roadNumber = roadNumber;
        this.status = status;
    }
    
    

    public int getRoadNumber() {
        return roadNumber;
    }

    public void setRoadNumber(int roadNumber) {
        this.roadNumber = roadNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.roadNumber);
    }
    
}
