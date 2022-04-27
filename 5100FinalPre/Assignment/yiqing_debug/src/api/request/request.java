/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import java.util.Date;

/**
 *
 * @author 10857
 */
public abstract class  request {
    String requestPersonId;
    String organizationId;
    int Id;
    String type;
    String status;
    Date startDate;
    Date endDate;
   private static int counter=0;
   
   public static int getNextId(){
        return ++counter;
    }

    public String getRequestPersonId() {
        return requestPersonId;
    }

    public void setRequestPersonId(String requestPersonId) {
        this.requestPersonId = requestPersonId;
    }

    public String getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(String organizationId) {
        this.organizationId = organizationId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }  
}
