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
import ui.Station.StationPanel;
import ui.captain.airCapPanel;
import ui.captain.TrainCaptainPanel;

/**
 *
 * @author 10857
 */
public class TrainCaptain extends Role{

    public TrainCaptain(){
        this.Role = "TrainCaptain";
    } 
        
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return null;
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return null;
    }
    
    public JPanel createWorkArea(JPanel parentPanel,Employee em,TravelSystem system, Organization o) {
        return new TrainCaptainPanel(parentPanel, null, em, system, o);
    }
    
}
