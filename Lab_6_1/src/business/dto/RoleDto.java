package business.dto;

import javax.swing.JPanel;

import business.type.RoleType;
import ui.CustomerRole.CustomerAreaJPanel;
import ui.DeliveryManRole.DeliveryManWorkAreaJPanel;
import ui.RestaurantRole.ResaurantWorkAreaJPanel;
import ui.SystemAdminWorkArea.SystemAdminWorkAreaJPanel;

public class RoleDto {
    private String roleName;

    public RoleDto(String roleName) {
        super();
        this.roleName = roleName;
    }
    
    public JPanel createWorkArea(JPanel userProcessContainer, UserDto userDto) {
        if (roleName.equals(RoleType.SysAdmin.getValue())) {
            return new SystemAdminWorkAreaJPanel(userProcessContainer, userDto);
        }
        else if (roleName.equals(RoleType.RestaurantAdmin.getValue())) {
            return new ResaurantWorkAreaJPanel(userProcessContainer, userDto);
        }
        else if (roleName.equals(RoleType.DeliveryMan.getValue())) {
            return new DeliveryManWorkAreaJPanel(userProcessContainer, userDto);
        }
        else if (roleName.equals(RoleType.Customer.getValue())) {
            return new CustomerAreaJPanel(userProcessContainer, userDto);
        }
        return null;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
