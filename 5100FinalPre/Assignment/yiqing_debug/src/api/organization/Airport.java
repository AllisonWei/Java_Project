/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.organization;

import api.employee.EmployeeDirectory;
import api.property.Airplane;
import api.property.Gate;
import api.property.Road;
import api.request.requestDirectory;
import api.userAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class Airport extends Organization{
    private ArrayList<Road> roadList;
    private ArrayList<Gate> gateList;
    
    public Airport(String name, String id, EmployeeDirectory employeeDirectory, requestDirectory requestDirectory, ArrayList<Road> roadList, ArrayList<Gate> gateList) {
        this.roadList = roadList;
        this.name = name;
        this.Id = id;
        this.employeeDirectory = employeeDirectory;
        this.requestDirectory = requestDirectory;
        this.gateList = gateList;
    }

    public ArrayList<Gate> getGateList() {
        return gateList;
    }

    public void setGateList(ArrayList<Gate> gateList) {
        this.gateList = gateList;
    }

    
    
    public ArrayList<Road> getRoadList() {
        return roadList;
    }

    public void setRoadList(ArrayList<Road> roadList) {
        this.roadList = roadList;
    }
    
    public void addRoad (Road r){
        this.roadList.add(r);
    }
    
    public void addGate (Gate g){
        this.gateList.add(g);
    }
    
    
}
