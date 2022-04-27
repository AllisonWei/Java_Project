/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Role;

import javax.swing.JPanel;

import api.TravelSystem;
import api.employee.Employee;
import api.organization.Organization;
import api.userAccount.UserAccount;
import ui.CustomerService.CustomerServicePanel;

/**
 *
 * @author 10857
 */
public class CustomerService extends Role{

    public CustomerService(){
        this.Role = "CustomerService";
    }
    
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new CustomerServicePanel(user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        // return new CustomerServicePanel(null ,em ,system, o);
        return null;
    }     
    
    public JPanel createWorkArea(JPanel parentPanel, Employee employee,TravelSystem system, Organization o) {
        return new CustomerServicePanel(parentPanel, employee, system, o);
    }
}
