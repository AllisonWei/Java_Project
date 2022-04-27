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
import ui.captain.AirlineCaptainPanel;

/**
 *
 * @author 10857
 */
public class AirCaptain extends Role{
    
    public AirCaptain(){
        this.Role = "AirCaptain";
    }
    
    @Override
    public JPanel createWorkArea(UserAccount user,TravelSystem system, Organization o) {
        return new AirlineCaptainPanel(null, user,null ,system, o);
    }
    
    @Override
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new AirlineCaptainPanel(null, null ,em ,system, o);
    }
    public JPanel createWorkArea(JPanel parentPanel,Employee em,TravelSystem system, Organization o) {
        return new AirlineCaptainPanel(parentPanel, null, em, system, o);
    }
    
}
