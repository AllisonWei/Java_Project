/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.organization;

import api.employee.EmployeeDirectory;
import api.property.Enter;
import api.property.Train;
import api.request.requestDirectory;
import api.userAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class Station extends Organization{
    private ArrayList<Enter> enterList;
    
    public Station(String name, String id,EmployeeDirectory employeeDirectory, requestDirectory requestDirectory, ArrayList<Enter> enterList) {
        this.enterList = enterList;
        this.name = name;
        this.Id = id;
        this.employeeDirectory = employeeDirectory;
        this.requestDirectory = requestDirectory;
    }

    public ArrayList<Enter> getEnterList() {
        return enterList;
    }

    public void setEnterList(ArrayList<Enter> enterList) {
        this.enterList = enterList;
    }
    
    public void addEnter(Enter e){
        this.enterList.add(e);
    }
}
