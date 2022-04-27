/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.request;

import java.util.ArrayList;

/**
 *
 * @author 10857
 */
public class requestDirectory {
    private ArrayList<request> requestList;

    public requestDirectory() {
        this.requestList = new ArrayList<request>();
    }

    public requestDirectory(ArrayList<request> requestList) {
        this.requestList = requestList;
    }
    
    

    public ArrayList<request> getRequestList() {
        return requestList;
    }

    public void setRequestList(ArrayList<request> requestList) {
        this.requestList = requestList;
    }
    
    
    public void addRequest(request r){
        this.requestList.add(r);
    }
}
