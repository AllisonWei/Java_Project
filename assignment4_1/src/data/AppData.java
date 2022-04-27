/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *
 * @author 36492
 */
public class AppData {
    private static List<City> cityList;
    private static List<Community> communityList;
    private static List<House> houseList;
    private static List<Person> personList;
     private static List<Patient> patientList;
    
     public static void initDate(){
         
         cityList=new ArrayList<City>();
         communityList=new ArrayList<Community>();
         houseList=new ArrayList<House>();
         personList=new ArrayList<Person>();
         patientList=new ArrayList<Patient>();
         
        City c1=new City();
        c1.setCityName("New York");
        cityList.add(c1);
        
         City c2=new City();
        c2.setCityName("Boston");
        cityList.add(c2);
        
         Community co1=new Community();
        co1.setCityName("New York");
        co1.setCommunityName("Manhattan");
        communityList.add(co1);
        
        Community co2=new Community();
        co2.setCityName("New York");
        co2.setCommunityName("Brooklyn");
        communityList.add(co2);
        
        Community co3=new Community();
        co3.setCityName("Boston");
        co3.setCommunityName("Fenway");
        communityList.add(co3);
        
        Community co4=new Community();
        co4.setCityName("Boston");
        co4.setCommunityName("Cambridge");
        communityList.add(co4);
        
        
        House h1=new House();
        h1.setCityName("Boston");
        h1.setCommunityName("Fenway");
        h1.setHouseName("House1");
        houseList.add(h1);
        House h2=new House();
        h2.setCityName("Boston");
        h2.setCommunityName("Fenway");
        h2.setHouseName("House2");
        houseList.add(h2);
        House h3=new House();
        h3.setCityName("Boston");
        h3.setCommunityName("Cambridge");
        h3.setHouseName("House3");
        houseList.add(h3);
        House h4=new House();
        h4.setCityName("Boston");
        h4.setCommunityName("Cambridge");
        h4.setHouseName("House4");
        houseList.add(h4);
        House h5=new House();
        h5.setCityName("New York");
        h5.setCommunityName("Manhattan");
        h5.setHouseName("House5");
        houseList.add(h5);
        House h6=new House();
        h6.setCityName("New York");
        h6.setCommunityName("Manhattan");
        h6.setHouseName("House6");
        houseList.add(h6);
        House h7=new House();
        h7.setCityName("New York");
        h7.setCommunityName("Brooklyn");
        h7.setHouseName("House7");
        houseList.add(h7);
        House h8=new House();
        h8.setCityName("New York");
        h8.setCommunityName("Brooklyn");
        h8.setHouseName("House8");
        houseList.add(h8);
     
        
        
        
        Person p1=new Person();
        p1.setCityName("Boston");
        p1.setCommunityName("Fenway");
        p1.setHouseName("House1");
        p1.setAge(35);
        p1.setGender("male");
        p1.setID("1111111");
        p1.setName("David Crane");
       
        personList.add(p1);
        

        Person p2=new Person();
        p2.setCityName("Boston");
        p2.setCommunityName("Fenway");
        p2.setHouseName("House1");
        p2.setAge(23);
        p2.setGender("male");
        p2.setID("1111112");
        p2.setName("Marta Kauffman");
        personList.add(p2);
        
        
        Person p3=new Person();
        p3.setCityName("Boston");
        p3.setCommunityName("Fenway");
        p3.setHouseName("House2");
        p3.setAge(41);
        p3.setGender("female");
        p3.setID("1111113");
        p3.setName("Jennifer Aniston");
        personList.add(p3);
        
        
        Person p4=new Person();
        p4.setCityName("Boston");
        p4.setCommunityName("Fenway");
        p4.setHouseName("House2");
        p4.setAge(52);
        p4.setGender("female");
        p4.setID("1111114");
        p4.setName("Courteney Cox");
        personList.add(p4);
        
        
        Person p5=new Person();
        p5.setCityName("Boston");
        p5.setCommunityName("Cambridge");
        p5.setHouseName("House3");
        p5.setAge(28);
        p5.setGender("female");
        p5.setID("1111115");
        p5.setName("Lisa Kudrow");
        personList.add(p5);
        
        
        Person p6=new Person();
        p6.setCityName("Boston");
        p6.setCommunityName("Cambridge");
        p6.setHouseName("House3");
        p6.setAge(65);
        p6.setGender("male");
        p6.setID("1111116");
        p6.setName("Matt LeBlanc");
        personList.add(p6);
        
        
        Person p7=new Person();
        p7.setCityName("Boston");
        p7.setCommunityName("Cambridge");
        p7.setHouseName("House4");
        p7.setAge(32);
        p7.setGender("male");
        p7.setID("1111117");
        p7.setName("David Schwimmer");
        personList.add(p7);
        
        Person p8=new Person();
        p8.setCityName("New York");
        p8.setCommunityName("Manhattan");
        p8.setHouseName("House5");
        p8.setAge(22);
        p8.setGender("female");
        p8.setID("1111119");
        p8.setName("Allee Willis");
        personList.add(p8);
        
        Person p9=new Person();
        p9.setCityName("New York");
        p9.setCommunityName("Manhattan");
        p9.setHouseName("House6");
        p9.setAge(50);
        p9.setGender("male");
        p9.setID("1111120");
        p9.setName("Adam Chase");
        personList.add(p9);
        
        Person p10=new Person();
        p10.setCityName("New York");
        p10.setCommunityName("Brooklyn");
        p10.setHouseName("House7");
        p10.setAge(76);
        p10.setGender("male");
        p10.setID("1111123");
        p10.setName("Scott Silveri");
        personList.add(p10);
        
        Person p11=new Person();
        p11.setCityName("New York");
        p11.setCommunityName("Brooklyn");
        p11.setHouseName("House8");
        p11.setAge(55);
        p11.setGender("male");
        p11.setID("1111124");
        p11.setName("Ted Cohen");
        personList.add(p11);
        
        
        initPatient();
    }
     
     
     public static void initPatient(){
         String[] bloodPressures = { "100/80", "102/95", "140/85", "98/75", "95/78", "120/70" , "125/82" , "85/60"  };
         String[] bdyTemperatures = { "36.2", "36.3", "36.4", "36.5", "36.6", "36.7" , "38.5" , "38.1"  };
         String[] pulses = { "110", "78", "73", "89", "68", "81" , "70" , "55"  };
         String[] dates = { "09/01/2021", "10/24/2021", "10/28/2021", "09/20/2021", "10/27/2021", "10/10/2021" , "10/18/2021" , "10/1/2021" };
         
         for(Person item:personList){
            Patient p=new Patient();
            p.setCityName(item.getCityName());
            p.setCommunityName(item.getCommunityName());
            p.setHouseName(item.getHouseName());
            p.setAge(item.getAge());
            p.setGender(item.getGender());
            p.setID(item.getID());
            p.setName(item.getName());

            EncounterHistory encounterHistory =p.getEncounterHistory();
            List<Encounter> encounters=encounterHistory.getEncounters();
           
            int lSize = (int) ( Math.random () * 3 )+2;
            for(int l=0;l<lSize;l++){
                Encounter e=new Encounter();
                int random = (int) ( Math.random () * 8 );
                e.setBloodPressure(bloodPressures[random]);
                int random1 = (int) ( Math.random () * 8 );
                e.setBodyTemperature(Double.valueOf(bdyTemperatures[random1]));
                int random2 = (int) ( Math.random () * 8);
                e.setPulse(Integer.valueOf(pulses[random2]));
                int random3 = (int) ( Math.random () * 6);
                e.setDate(dates[random3]);
                encounters.add(e);
         
            }
            patientList.add(p);

         }
         
     }
     
     
     
    public static List<City> addCity(City c) {
        cityList.add(c);
        return cityList;
    }
     
    public static List<Community> addCommunity(Community c) {
        communityList.add(c);
        return communityList;
    }
    public static List<Community> delCommunity(String cityName, String communityName) {
        Community del=null;
        for(Community item:communityList){
            if(item.getCityName().equals(cityName)&&item.getCommunityName().equals(communityName)){
                del=item;
            }
        }
        communityList.remove(del);
        return communityList;
    }
    
    
   
    
    
 
    public static List<House> addHouse(House c) {
        houseList.add(c);
        return houseList;
    }
    public static List<House> delHouse(String cityName, String communityName, String houseName) {
        House del=null;
        for(House item:houseList){
            if(item.getCityName().equals(cityName)&&item.getCommunityName().equals(communityName)&&item.getHouseName().equals(houseName)){
                del=item;
            }
        }
        houseList.remove(del);
        return houseList;
    }
    
    
    public static Person getPerson(String cityName, String communityName, String houseName, String Name) {
        for(Person item:personList){
            if(item.getCityName().equals(cityName)
                    &&item.getCommunityName().equals(communityName)
                    &&item.getHouseName().equals(houseName)
                    &&item.getName().equals(Name)){
               return item;
            }
        }
        return null;
    }
    
   public static List<Person> addPerson(Person c) {
        personList.add(c);
        return personList;
    }
   public static List<Person> delPerson(String cityName, String communityName, String houseName, String name) {
       Person del=null;
        for(Person item:personList){
            if(item.getCityName().equals(cityName)
                    &&item.getCommunityName().equals(communityName)
                    &&item.getHouseName().equals(houseName)
                    &&item.getName().equals(name)){
                del=item;
            }
        }
        personList.remove(del);
        return personList;
    }

    
    
    public static List<Patient> addPatient(Patient p) {
       patientList.add(p);
        return patientList;
    }
    
    
    
    public static Patient getPatient(String cityName, String communityName, String houseName,String name) {
       
        for(Patient item:patientList){
            if(item.getCityName().equals(cityName)
                    &&item.getCommunityName().equals(communityName)
                    &&item.getHouseName().equals(houseName)
                    &&item.getName().equals(name)){
               return item;
            }
        }
        return null;
    }
    public static List<Patient> delPatient(String cityName, String communityName, String houseName,String name) {
        Patient del=null;
        for(Patient item:patientList){
            if(item.getCityName().equals(cityName)
                    &&item.getCommunityName().equals(communityName)
                    &&item.getHouseName().equals(houseName)
                    &&item.getName().equals(name)){
                del=item;
            }
        }
        patientList.remove(del);
        return patientList;
    }
    
    
    public static List<Encounter> delEncounter(String cityName, String communityName, String houseName,String name,String date,String date1,String date2,String date3) {
        Patient p=AppData.getPatient(cityName, communityName, houseName, name);
        List<Encounter> encounters= p.getEncounterHistory().getEncounters();
        
        Encounter del=null;
        for(Encounter item:encounters){
            if(item.getDate().equals(date)&&item.getBloodPressure().equals(date1)){
                del=item;
            }
        }
        encounters.remove(del);
        return encounters;
    }
    
    
    
    
    
    
    
    
    
    
    public static List<City> getCityList() {
        return cityList;
    }

    public static void setCityList(List<City> cityList) {
        AppData.cityList = cityList;
    }

    public static List<Community> getCommunityList() {
        return communityList;
    }

    public static void setCommunityList(List<Community> communityList) {
        AppData.communityList = communityList;
    }

    public static List<House> getHouseList() {
        return houseList;
    }

    public static void setHouseList(List<House> houseList) {
        AppData.houseList = houseList;
    }

    public static List<Person> getPersonList() {
        return personList;
    }

    public static void setPersonList(List<Person> personList) {
        AppData.personList = personList;
    }

    public static List<Patient> getPatientList() {
        return patientList;
    }

    public static void setPatientList(List<Patient> patientList) {
        AppData.patientList = patientList;
    }   
    
}

