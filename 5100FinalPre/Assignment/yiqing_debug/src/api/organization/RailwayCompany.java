/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.organization;

import api.employee.EmployeeDirectory;
import api.property.Road;
import api.property.Train;
import api.request.requestDirectory;
import api.userAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class RailwayCompany extends Organization{
    private ArrayList<Train> trainList;
    
    public RailwayCompany(String name, String id, UserAccountDirectory userDirectory, EmployeeDirectory employeeDirectory, requestDirectory requestDirectory, ArrayList<Train> trainList) {
        this.trainList = trainList;
        this.name = name;
        this.Id = id;
        this.userAccountDirectory = userDirectory;
        this.employeeDirectory = employeeDirectory;
        this.requestDirectory = requestDirectory;
    }

    public ArrayList<Train> getTrainList() {
        return trainList;
    }

    public void setTrainList(ArrayList<Train> trainList) {
        this.trainList = trainList;
    }
    
    public void addTrain(Train t){
        this.trainList.add(t);
    }
    
}
