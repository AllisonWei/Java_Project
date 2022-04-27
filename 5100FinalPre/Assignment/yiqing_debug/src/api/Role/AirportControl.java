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
import ui.AirlineCompany.AirlineCompanyPanel;
import ui.Airport.AirportPanel;

/**
 *
 * @author 10857
 */
public class AirportControl extends Role{
   
    public AirportControl(){
        this.Role = "AirportControl";
    }
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new AirportPanel(null,user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new AirportPanel(null,null ,em ,system, o);
    } 
    
    public JPanel createWorkArea( JPanel parentPanel,Employee employee,TravelSystem system, Organization o) {
        return new AirportPanel(parentPanel, null, employee, system, o);
    }
    
}
