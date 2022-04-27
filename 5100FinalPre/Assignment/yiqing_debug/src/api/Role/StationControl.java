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
import ui.RailwayCompany.RailwayCompanyPanel;
import ui.Station.StationPanel;

/**
 *
 * @author 10857
 */
public class StationControl extends Role{
    
    public StationControl(){
        this.Role = "StationControl";
    } 
    
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new StationPanel(null,user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new StationPanel(null,null ,em ,system, o);
    }     
    
    public JPanel createWorkArea( JPanel parentPanel,Employee employee,TravelSystem system, Organization o) {
        return new StationPanel(parentPanel, null, employee, system, o);
    }
}
