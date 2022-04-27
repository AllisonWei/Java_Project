/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import api.property.Gate;
import api.property.Road;
import java.util.Date;

/**
 *
 * @author 10857
 */
public class Landing extends request{
    private Flight flight;
    private Road road;
    private Gate gate;
    
    public Landing(String pid, String oid, String type, String status, Date sDate, Date eDate, int id , Flight flight, Road road, Gate gate) {
        this.flight = flight;
        this.road = road;
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;
        this.status = status;
        this.startDate = sDate;
        this.endDate = eDate;
        this.Id = id;
        this.gate = gate;
    }
    
    public Landing(String type, String status, Flight flight) {
        this.Id = request.getNextId();
        this.flight = flight;
        this.requestPersonId = flight.getRequestPersonId();
        this.organizationId = flight.getOrganizationId();
        this.type = type;
        this.status = status;
        this.startDate = new Date();
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }
    
    public void Finish(){
        Date now = new Date();
        this.getFlight().setEndDate(now);
        this.setEndDate(now);
    }
    
}
