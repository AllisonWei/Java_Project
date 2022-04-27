/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.employee;

import api.Role.Role;

public class Employee {
    
     private String name;
    private int id;
    private String employeeAccount;
    private String employeePassword;
    private int salary;
    private Role role; 
    private String Status;
    
    public Employee(String name, int id, String employeeAccount, String employeePassword, int salary, Role role){
        this.employeeAccount = employeeAccount;
        this.name = name;
        this.id = id;
        this.employeePassword = employeePassword;
        this.salary = salary;
        this.role = role;
        this.Status = "Activated";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeAccount() {
        return employeeAccount;
    }

    public void setEmployeeAccount(String employeeAccount) {
        this.employeeAccount = employeeAccount;
    }

    public String getEmployeePassword() {
        return employeePassword;
    }

    public void setEmployeePassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
}
