/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 10857
 */
public class TrainTicket extends request{
    private ArrayList<String> stationList;
    private int time;
    private int TrainLineId;
    private double totalPrice;
    private int number;
    private String message;
    
    public TrainTicket(String pid, String oid, String type, String status, Date sDate, Date eDate, int id) {
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;
        this.status = status;
        this.startDate = sDate;
        this.endDate = eDate;
        this.Id = id;
        this.message = null;
    }
    
    public void setTrainTicket(ArrayList<String> stationList, int time, int TrainLineId, double totalPrice, int number){
        this.stationList = stationList;
        this.time = time;
        this.TrainLineId = TrainLineId;
        this.totalPrice = totalPrice;
        this.number = number;
      
    }

    public ArrayList<String> getStationList() {
        return stationList;
    }

    public void setStationList(ArrayList<String> stationList) {
        this.stationList = stationList;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTrainLineId() {
        return TrainLineId;
    }

    public void setTrainLineId(int TrainLineId) {
        this.TrainLineId = TrainLineId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
