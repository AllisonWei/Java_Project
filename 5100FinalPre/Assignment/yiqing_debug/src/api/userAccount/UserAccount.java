/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.userAccount;

import api.employee.Employee;
import api.Role.Role;
import api.request.requestDirectory;

/**
 *
 * @author raunak
 */
public class UserAccount {
    
    private String username;
    private String password;
    private int Id; 
    private String realName;
    private Role role;
    private String Status;
    private requestDirectory requestDirectory;

    public UserAccount(String username, String password, int Id, String realName, Role role, requestDirectory requestDirectory) {
        this.username = username;
        this.password = password;
        this.Id = Id;
        this.realName = realName;
        this.role = role;
        this.requestDirectory = requestDirectory;
        this.Status = "Activated";
    }
    
    
    
    @Override
    public String toString() {
        return username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public requestDirectory getRequestDirectory() {
        return requestDirectory;
    }

    public void setRequestDirectory(requestDirectory requestDirectory) {
        this.requestDirectory = requestDirectory;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    
    
    
}