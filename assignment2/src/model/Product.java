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
public class Product {
    private String carName;
    private String manu;
    private String city;
    private int year;
    private int seat;
    private double serialNumber;
    private String modelNumber;
    private String certificate;
    private String avail;
    private int idNumber;
    
    private static int count = 0;
    
    @Override
    public String toString(){
        return carName;
    }
    
    public Product(){
        count++;
        idNumber = count;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getAvail() {
        return avail;
    }

    public void setAvail(String avail) {
        this.avail = avail;
    }

    public String getManu() {
        return manu;
    }

    public void setManu(String manu) {
        this.manu = manu;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public double getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(double serialNumber) {
        this.serialNumber = serialNumber;
    }

    

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }
   

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }
    
    public Object[] toArray() {
    	return new Object[] {carName,manu,year,seat,serialNumber,modelNumber,city,certificate,avail};
    }
  }
