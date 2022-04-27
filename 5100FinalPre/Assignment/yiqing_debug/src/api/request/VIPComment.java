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
public class VIPComment extends request{
    private String comment;
    
    
    public VIPComment(String pid, String oid, String type, String status, Date sDate, Date eDate,int id, String comment) {
        this.comment = comment;
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;
        this.status = status;
        this.startDate = sDate;
        this.endDate = eDate;
        this.Id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
