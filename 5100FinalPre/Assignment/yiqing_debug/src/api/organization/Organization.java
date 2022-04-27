/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.organization;

import api.employee.EmployeeDirectory;
import api.request.requestDirectory;
import api.userAccount.UserAccountDirectory;

/**
 *
 * @author 10857
 */
public abstract class Organization {
    String name;
    String Id;
    UserAccountDirectory userAccountDirectory;
    EmployeeDirectory employeeDirectory;
    requestDirectory requestDirectory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public requestDirectory getRequestDirectory() {
        return requestDirectory;
    }

    public void setRequestDirectory(requestDirectory requestDirectory) {
        this.requestDirectory = requestDirectory;
    }
    
    
    
}
