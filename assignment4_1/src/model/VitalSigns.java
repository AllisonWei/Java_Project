/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Lynn Wei
 */
public class VitalSigns {
    private String bloodPressure;
    private double bodyTemperature;
    private int pulse;
    
    public String getBloodPressure(){
        return bloodPressure;
    }
    public void setBloodPressure(String bloodPressure){
        this.bloodPressure = bloodPressure;
    }
    public double getBodyTemperature(){
        return bodyTemperature;
    }
    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }
    public int getPulse(){
        return pulse;
    }
    public void setPulse(int pulse){
        this.pulse = pulse;
    }
    
}
