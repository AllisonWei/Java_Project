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
public class Person extends House{
    private String name;
    private String id;
    private String gender;
    private int age;
    
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getID(){
        return id;
    }
    public void setID(String id){
        this.id = id;
    }
     public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", id=" + id + ", gender=" + gender + ", age=" + age + '}';
    }
  
    
    
}
