/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.organization;

import api.employee.EmployeeDirectory;
import api.property.Airplane;
import api.request.Flight;
import api.request.requestDirectory;
import api.userAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class AirlineCompany extends Organization{
    private ArrayList<Airplane> airplaneList;

    public AirlineCompany(String name, String id, UserAccountDirectory userDirectory, EmployeeDirectory employeeDirectory, requestDirectory requestDirectory, ArrayList<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
        this.name = name;
        this.Id = id;
        this.userAccountDirectory = userDirectory;
        this.employeeDirectory = employeeDirectory;
        this.requestDirectory = requestDirectory;
    }

    public ArrayList<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(ArrayList<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }
    
    public void addAirplane (Airplane a){
        this.airplaneList.add(a);
    }
}
