
package api;

import api.employee.EmployeeDirectory;
import api.Role.Role;
import api.userAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public abstract class Organization {

    private String name;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private int organizationID;
    private static int counter=0;
    
    public enum Type{
        RestaurantAdmin("RestaurantAdmin"),
        Customer("Customer"),
        DeliveryMan("Delivery"),
        SysAdmin("Sysadmin");
        
        private String value;
        private Type(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        employeeDirectory = new EmployeeDirectory();
        userAccountDirectory = new UserAccountDirectory();
        organizationID = counter;
        ++counter;
    }
    public Organization(){
        
    }
    public abstract ArrayList<Role> getSupportedRole();
    
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public int getOrganizationID() {
        return organizationID;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
    
    
}
