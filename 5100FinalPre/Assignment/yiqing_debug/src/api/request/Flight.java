/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import api.employee.Employee;
import api.property.Airplane;
import java.util.Date;

/**
 *
 * @author 10857
 */
public class Flight extends request{
    private String startAirport;
    private String endAirport;
    private String starTime;
    private Airplane airplane;
    private Employee captain;
    private int remainEco;
    private int remainBus;
    private int remainFirst;
    private double ecoPrice;
    private double busPrice;
    private double firstPrice;
    
    public Flight(String pid, String oid, String type, String status, Date sDate, Date eDate, int id) {
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;
        this.status = status;
        this.startDate = sDate;
        this.endDate = eDate;
        this.Id = id;
    }
    
    public void setFlight(String sA, String eA, Airplane plane, Employee cap, int rE, int rB, int rF, double eP, double bP, double fP){
        this.startAirport = sA;
        this.endAirport = eA;
        this.airplane = plane;
        this.captain = cap;
        this.remainEco = rE;
        this.remainBus = rB;
        this.remainFirst = rF;
        this.ecoPrice = eP;
        this.busPrice = bP;
        this.firstPrice = fP;
    }

   

    public String getStartAirport() {
        return startAirport;
    }

    public void setStartAirport(String startAirport) {
        this.startAirport = startAirport;
    }

    public String getEndAirport() {
        return endAirport;
    }

    public void setEndAirport(String endAirport) {
        this.endAirport = endAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }

    public Employee getCaptain() {
        return captain;
    }

    public void setCaptain(Employee captain) {
        this.captain = captain;
    }

    public int getRemainEco() {
        return remainEco;
    }

    public void setRemainEco(int remainEco) {
        this.remainEco = remainEco;
    }

    public int getRemainBus() {
        return remainBus;
    }

    public void setRemainBus(int remainBus) {
        this.remainBus = remainBus;
    }

    public int getRemainFirst() {
        return remainFirst;
    }

    public void setRemainFirst(int remainFirst) {
        this.remainFirst = remainFirst;
    }

    public double getEcoPrice() {
        return ecoPrice;
    }

    public void setEcoPrice(double ecoPrice) {
        this.ecoPrice = ecoPrice;
    }

    public double getBusPrice() {
        return busPrice;
    }

    public void setBusPrice(double busPrice) {
        this.busPrice = busPrice;
    }

    public double getFirstPrice() {
        return firstPrice;
    }

    public void setFirstPrice(double firstPrice) {
        this.firstPrice = firstPrice;
    }
    
    
}
