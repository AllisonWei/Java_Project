/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.enterprise;

import api.organization.OrganizationDirectory;

/**
 *
 * @author 10857
 */
public class Enterprise {
    private String name;
    private int Id;
    private OrganizationDirectory organizationDirectory;

    public Enterprise(String name, int Id, OrganizationDirectory organizationDirectory) {
        this.name = name;
        this.Id = Id;
        this.organizationDirectory = organizationDirectory;
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }
    
    
    
}
