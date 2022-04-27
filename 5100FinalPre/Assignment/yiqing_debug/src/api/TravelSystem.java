/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import api.Role.Role;
import api.Role.sysAdmin;
import api.employee.Employee;
import api.enterprise.Enterprise;
import api.enterprise.EnterpriseDirectory;
import java.util.ArrayList;

public class TravelSystem extends Organization{
    
    private static TravelSystem business;
    
    private Employee admin;
    private String name; 
    private EnterpriseDirectory enterpriseDirectory;

    public TravelSystem(String name, Employee admin, EnterpriseDirectory enterpriseDirectory) {
        this.admin = admin;
        this.name = name;
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    public api.organization.Organization getOrganizationByNameAndType(String type, String name){
        for (Enterprise enterprise :this.enterpriseDirectory.getEnterpriseList()){
            if (!enterprise.getName().equals(type)){
                continue;
            }
            for(api.organization.Organization organization: enterprise.getOrganizationDirectory().getOrganizationList()){
                if(organization.getName().contains(name)){
                    return organization;
                }
            }
        }
        return null;
    }

    public api.organization.Organization getOrganizationByIdAndType(String type, String id){
        for (Enterprise enterprise :this.enterpriseDirectory.getEnterpriseList()){
            if (!enterprise.getName().equals(type)){
                continue;
            }
            for(api.organization.Organization organization: enterprise.getOrganizationDirectory().getOrganizationList()){
                if(organization.getId().equals(id)){
                    return organization;
                }
            }
        }
        return null;
    }

    public static TravelSystem getBusiness() {
        return business;
    }

    public static void setBusiness(TravelSystem business) {
        TravelSystem.business = business;
    }

    public Employee getAdmin() {
        return admin;
    }

    public void setAdmin(Employee admin) {
        this.admin = admin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }
    
    
    
    public static TravelSystem getInstance(){
        if(business==null){
            business=new TravelSystem();
        }
        return business;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList=new ArrayList<Role>();
        roleList.add(new sysAdmin());
        return roleList;
    }
    
    private TravelSystem(){
        super(null);
    }

}
