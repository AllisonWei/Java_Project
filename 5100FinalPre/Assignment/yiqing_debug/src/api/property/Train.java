/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package api.property;

/**
 *
 * @author 10857
 */
public class Train {
    private String Id;
    private String type;
    private int year;
    private int age;
    private int seatNumber;
    private int secondSeatNumber;
    private int firstSeatNumber;
    private int sleeperNumber;
    private int firstSleeperNumber;
    private int speed;

    public Train(String Id, String type, int year, int age, int seatNumber, int secondSeatNumber, int firstSeatNumber, int sleeperNumber, int firstSleeperNumber, int speed) {
        this.Id = Id;
        this.type = type;
        this.year = year;
        this.age = age;
        this.seatNumber = seatNumber;
        this.secondSeatNumber = secondSeatNumber;
        this.firstSeatNumber = firstSeatNumber;
        this.sleeperNumber = sleeperNumber;
        this.firstSleeperNumber = firstSleeperNumber;
        this.speed = speed;
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

    public int getSecondSeatNumber() {
        return secondSeatNumber;
    }

    public void setSecondSeatNumber(int secondSeatNumber) {
        this.secondSeatNumber = secondSeatNumber;
    }

    public int getFirstSeatNumber() {
        return firstSeatNumber;
    }

    public void setFirstSeatNumber(int firstSeatNumber) {
        this.firstSeatNumber = firstSeatNumber;
    }

    public int getSleeperNumber() {
        return sleeperNumber;
    }

    public void setSleeperNumber(int sleeperNumber) {
        this.sleeperNumber = sleeperNumber;
    }

    public int getFirstSleeperNumber() {
        return firstSleeperNumber;
    }

    public void setFirstSleeperNumber(int firstSleeperNumber) {
        this.firstSleeperNumber = firstSleeperNumber;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
    
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
