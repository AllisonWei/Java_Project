/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.property;

/**
 *
 * @author 10857
 */
public class Airplane {
    private String Id;
    private String type;
    private int year;
    private int age;
    private int seatNumber;
    private int ecoSeatNumber;
    private int busSeatNumber;
    private int firstSeatNumber;

    public Airplane(String Id, String type, int year, int age, int seatNumber, int ecoSeatNumber, int busSeatNumber, int firstSeatNumber) {
        this.Id = Id;
        this.type = type;
        this.year = year;
        this.age = age;
        this.seatNumber = seatNumber;
        this.ecoSeatNumber = ecoSeatNumber;
        this.busSeatNumber = busSeatNumber;
        this.firstSeatNumber = firstSeatNumber;
    }
    
    

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }
    
    public int getSeatNumber(){
        return seatNumber;
    }
    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    public int getEcoSeatNumber() {
        return ecoSeatNumber;
    }

    public void setEcoSeatNumber(int ecoSeatNumber) {
        this.ecoSeatNumber = ecoSeatNumber;
    }

    public int getBusSeatNumber() {
        return busSeatNumber;
    }

    public void setBusSeatNumber(int busSeatNumber) {
        this.busSeatNumber = busSeatNumber;
    }

    public int getFirstSeatNumber() {
        return firstSeatNumber;
    }

    public void setFirstSeatNumber(int firstSeatNumber) {
        this.firstSeatNumber = firstSeatNumber;
    }
    
    
}
