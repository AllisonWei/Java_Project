/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 36492
 */
public class SearchVO extends Person{
    private String date;
    private String bloodPressure;
    private double bodyTemperature;
    private int pulse;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(String bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public int getPulse() {
        return pulse;
    }

    public void setPulse(int pulse) {
        this.pulse = pulse;
    }
    
    
}
