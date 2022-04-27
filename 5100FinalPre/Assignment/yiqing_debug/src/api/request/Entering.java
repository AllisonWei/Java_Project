/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import api.property.Enter;
import java.util.Date;

/**
 *
 * @author 10857
 */
public class Entering extends request{
    private TrainLine trainLine;
    private Enter enter;

    public Entering(String pid, String oid, String type, String status, Date sDate, Date eDate, int id , TrainLine trainLine, Enter enter) {
        this.trainLine = trainLine;
        this.enter = enter;
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;
        this.status = status;
        this.startDate = sDate;
        this.endDate = eDate;
        this.Id = id;
    }
    
    public Entering(String type, String status, TrainLine trainLine){
        this.Id = request.getNextId();
        this.requestPersonId = trainLine.getRequestPersonId();
        this.organizationId = trainLine.getOrganizationId();
        this.type = type;
        this.status = status;
        this.trainLine = trainLine;
        this.startDate = new Date();
    }
    
    

    public TrainLine getTrainLine() {
        return trainLine;
    }

    public void setTrainLine(TrainLine trainLine) {
        this.trainLine = trainLine;
    }

    public Enter getEnter() {
        return enter;
    }

    public void setEnter(Enter enter) {
        this.enter = enter;
    }
    
    public void Finish(){
        Date now = new Date();
        this.getTrainLine().setEndDate(now);
        this.setEndDate(now);
    }
    
    
}
