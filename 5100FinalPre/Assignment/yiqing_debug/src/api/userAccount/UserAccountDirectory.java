/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package api.userAccount;

import api.employee.Employee;
import api.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author raunak
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        this.userAccountList = new ArrayList();
    }

    public UserAccountDirectory(ArrayList<UserAccount> userAccountList) {
        this.userAccountList = userAccountList;
    }
    
    

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }
    
    public boolean accountNameCheck(String accountName){
        for(UserAccount e : this.userAccountList){
            if(e.getUsername().equals(accountName)){
                return false;
            }
        }
        return true;
    }
    
    public void addUser(UserAccount u){
        this.userAccountList.add(u);
    } 
}
