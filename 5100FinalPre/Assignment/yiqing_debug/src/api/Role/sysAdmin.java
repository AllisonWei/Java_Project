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
import ui.CustomerService.CustomerServicePanel;
import ui.admin.AdminMainPanel;
import ui.admin.AdminPanel;

/**
 *
 * @author raunak
 */
public class sysAdmin extends Role{

    public sysAdmin(){
        this.Role = "sysAdmin";
    } 
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new AdminMainPanel(user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new AdminMainPanel(null ,em ,system, o);
    }    
    
}

