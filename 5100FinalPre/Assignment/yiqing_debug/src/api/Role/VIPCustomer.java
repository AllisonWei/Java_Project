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

/**
 *
 * @author 10857
 */
public class VIPCustomer extends Role{

    public VIPCustomer(){
        this.Role = "VIPCustomer";
    } 
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new CustomerPanel(user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new CustomerPanel(null ,em ,system, o);
    }    
}
