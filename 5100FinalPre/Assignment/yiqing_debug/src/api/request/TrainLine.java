/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import api.employee.Employee;
import api.property.Train;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author 10857
 */
public class TrainLine extends request{
    private ArrayList<String> stationList;
    private String currentStation;
    private int time;
    private Employee captain;
    private Train train;
    private int remainSecondSeat;
    private int remainFirstSeat;
    private int remainSleeper;
    private int remainFirstSleeper;
    private double secondSeatPrice;
    private double firstSeatPrice;
    private double sleeperPrice;
    private double firstSleeperPrice;
    
    public TrainLine(){
        this.currentStation = "";
    }
    
    public TrainLine(String pid, String oid, String type, String status, Date sDate, Date eDate,int id) {
        this();
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;
        this.status = status;
        this.startDate = sDate;
        this.endDate = eDate;
        this.Id = id;
    }
    
    public void setTrainLine(ArrayList<String> sL, int t, Employee cap, Train tr, int rSS, int rFSS, int rS, int rFS, double sSP, double fSSP, double sP, double fSP){
        this.stationList = sL;
        this.time = t;
        this.captain = cap;
        this.train = tr;
        this.remainSecondSeat = rSS;
        this.remainFirstSeat = rFSS;
        this.remainSleeper = rS;
        this.remainFirstSleeper = rFS;
        this.secondSeatPrice = sSP;
        this.firstSeatPrice = fSSP;
        this.sleeperPrice = sP;
        this.firstSleeperPrice = fSP;
    }
    
    
    public String getCurrentStation(){
        if (this.currentStation.isEmpty() && !this.stationList.isEmpty()){
            this.currentStation = this.stationList.get(0);
        }
        return this.currentStation;
    }
    
    public boolean moveNextStation(){
        String next = this.getNextStation();
        if (!next.isEmpty()){
            this.currentStation = next;
            return true;
        }
        return false;
    }
    
    public String getNextStation(){
        int index = this.stationList.indexOf(this.getCurrentStation());
        if (index<0 || index == this.stationList.size() - 1) {
            return "";
        }
        return this.stationList.get(index+1);
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

    public Employee getCaptain() {
        return captain;
    }

    public void setCaptain(Employee captain) {
        this.captain = captain;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public int getRemainSecondSeat() {
        return remainSecondSeat;
    }

    public void setRemainSecondSeat(int remainSecondSeat) {
        this.remainSecondSeat = remainSecondSeat;
    }

    public int getRemainFirstSeat() {
        return remainFirstSeat;
    }

    public void setRemainFirstSeat(int remainFirstSeat) {
        this.remainFirstSeat = remainFirstSeat;
    }

    public int getRemainSleeper() {
        return remainSleeper;
    }

    public void setRemainSleeper(int remainSleeper) {
        this.remainSleeper = remainSleeper;
    }

    public int getRemainFirstSleeper() {
        return remainFirstSleeper;
    }

    public void setRemainFirstSleeper(int remainFirstSleeper) {
        this.remainFirstSleeper = remainFirstSleeper;
    }

    public double getSecondSeatPrice() {
        return secondSeatPrice;
    }

    public void setSecondSeatPrice(double secondSeatPrice) {
        this.secondSeatPrice = secondSeatPrice;
    }

    public double getFirstSeatPrice() {
        return firstSeatPrice;
    }

    public void setFirstSeatPrice(double firstSeatPrice) {
        this.firstSeatPrice = firstSeatPrice;
    }

    public double getSleeperPrice() {
        return sleeperPrice;
    }

    public void setSleeperPrice(double sleeperPrice) {
        this.sleeperPrice = sleeperPrice;
    }

    public double getFirstSleeperPrice() {
        return firstSleeperPrice;
    }

    public void setFirstSleeperPrice(double firstSleeperPrice) {
        this.firstSleeperPrice = firstSleeperPrice;
    }
    
    
    
}
