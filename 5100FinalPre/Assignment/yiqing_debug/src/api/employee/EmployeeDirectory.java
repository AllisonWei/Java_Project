/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.employee;

import java.util.ArrayList;

public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    
    
    public EmployeeDirectory() {
        employeeList = new ArrayList();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public boolean accountNameCheck(String accountName){
        for(Employee e : this.employeeList){
            if(e.getEmployeeAccount().equals(accountName)){
                return false;
            }
        }
        return true;
    }
    
    public void addEmployee(Employee e){
        this.employeeList.add(e);
    }
}