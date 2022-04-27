/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.organization;

import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class OrganizationDirectory {
    ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList<Organization>();
    }
    
    

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(ArrayList<Organization> organizationList) {
        this.organizationList = organizationList;
    }
    
    public void addOrganization(Organization o){
        this.organizationList.add(o);
    }
}
