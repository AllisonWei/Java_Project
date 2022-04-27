/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.Role;

import api.TravelSystem;
import api.employee.Employee;
import api.organization.Organization;
import api.userAccount.UserAccount;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public abstract class Role {
    
    String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    
    
    public abstract JPanel createWorkArea(UserAccount user,TravelSystem business, Organization o);
    
    public abstract JPanel createWorkArea(Employee employee,TravelSystem business, Organization o);
    
        
    public JPanel createWorkArea( JPanel parentPanel,UserAccount user,TravelSystem business, Organization o) {
        return null;
    }
    
    public JPanel createWorkArea( JPanel parentPanel,Employee employee,TravelSystem business, Organization o) {
        return null;
    }

    @Override
    public String toString() {
        return this.getClass().getName();
    }
    
    
}