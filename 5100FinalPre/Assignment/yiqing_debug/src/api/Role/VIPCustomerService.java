/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Role;

import api.TravelSystem;
import api.employee.Employee;
import api.organization.Organization;
import api.userAccount.UserAccount;
import javax.swing.JPanel;
import ui.Customer.CustomerPanel;
import ui.CustomerService.CustomerServicePanel;
import ui.CustomerService.VIPCustomerServicePanel;

/**
 *
 * @author 10857
 */
public class VIPCustomerService extends Role{
    
    public VIPCustomerService(){
        this.Role = "VIPCustomerService";
    } 
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new VIPCustomerServicePanel(user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        // return new VIPCustomerServicePanel(null ,em ,system, o);
        return null;
    }
    
    public JPanel createWorkArea( JPanel parentPanel, Employee employee, TravelSystem business, Organization o) {
        return new VIPCustomerServicePanel(parentPanel, employee, business, o);
    }
}
