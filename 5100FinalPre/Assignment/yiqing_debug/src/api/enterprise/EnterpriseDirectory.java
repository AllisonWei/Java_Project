/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.enterprise;

import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;

    public EnterpriseDirectory(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    

    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public void addEnterprise(Enterprise en){
        this.enterpriseList.add(en);
    }
}
