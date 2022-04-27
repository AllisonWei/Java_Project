/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.Role;

import api.TravelSystem;
import api.employee.Employee;
import api.organization.Organization;
import api.property.Airplane;
import api.userAccount.UserAccount;
import javax.swing.JPanel;
import ui.AirlineCompany.AirlineCompanyPanel;

/**
 *
 * @author 10857
 */
public class AirlineComManager extends Role{

    public AirlineComManager(){
        this.Role = "AirlineComManager";
    }
    
    public JPanel createWorkArea( UserAccount user,TravelSystem system, Organization o ) {
        return new AirlineCompanyPanel(null, user,null ,system, o);
    }
    
    public JPanel createWorkArea(Employee em,TravelSystem system, Organization o) {
        return new AirlineCompanyPanel(null, null ,em ,system, o);
    }
    
    public JPanel createWorkArea( JPanel parentPanel,Employee employee,TravelSystem system, Organization o) {
        return new AirlineCompanyPanel(parentPanel, null, employee, system, o);
    }
}
