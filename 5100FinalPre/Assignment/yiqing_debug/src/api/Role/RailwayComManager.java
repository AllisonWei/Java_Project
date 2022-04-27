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
import ui.RailwayCompany.RailwayCompanyPanel;

/**
 *
 * @author 10857
 */
public class RailwayComManager extends Role{

    public RailwayComManager(){
        this.Role = "RailwayCompanyManager";
    }
    
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new RailwayCompanyPanel(null,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new RailwayCompanyPanel(null,em ,system, o);
    }     
    
    public JPanel createWorkArea( JPanel parentPanel,Employee employee,TravelSystem system, Organization o) {
        return new RailwayCompanyPanel(parentPanel, employee, system, o);
    }
}
