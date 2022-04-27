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
public class FlightTicket extends request{
    private int flightId;
    private int number;
    private double totalPrice;
    private String message;
    
    public FlightTicket(String pid, String oid, String type, String status, Date sDate, Date eDate, int id) {
        this.requestPersonId = pid;
        this.organizationId = oid;
        this.type = type;//flightticket/trainticket 所有request里面的type都是原名称
        this.status = status;//客服只能看Finished
        this.startDate = sDate;//下单时间
        this.endDate = eDate;//客服处理时间
        this.Id = id;//订单号
      
    }
    
    public void setFlightTicket(int flightId, int number, double totalPrice){
        this.flightId = flightId;
        this.number = number;
        this.totalPrice = totalPrice;
        this.message = null;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
