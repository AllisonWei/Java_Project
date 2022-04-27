/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Lynn Wei
 */
public class Product {
    private String name;
    private String geo_data;
    private String dob;
    private String tele_num;
    private String fax_num;
    private String email_add;
    private String ssn;
    private String medi_num;
    private String health_num;
    private String bank_num;
    private String certi_num;
    private String vehicle_iden;
    private String device_iden;
    private String linkedln;
    private String inter_add;
    private String nuid_num;

    private String icon_path;

    public String getIcon_path() {
        return icon_path;
    }

    public void setIcon_path(String icon_path) {
        this.icon_path = icon_path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeo_data() {
        return geo_data;
    }

    public void setGeo_data(String geo_data) {
        this.geo_data = geo_data;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getTele_num() {
        return tele_num;
    }

    public void setTele_num(String tele_num) {
        this.tele_num = tele_num;
    }

    public String getFax_num() {
        return fax_num;
    }

    public void setFax_num(String fax_num) {
        this.fax_num = fax_num;
    }

    public String getEmail_add() {
        return email_add;
    }

    public void setEmail_add(String email_add) {
        this.email_add = email_add;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getMedi_num() {
        return medi_num;
    }

    public void setMedi_num(String medi_num) {
        this.medi_num = medi_num;
    }

    public String getHealth_num() {
        return health_num;
    }

    public void setHealth_num(String health_num) {
        this.health_num = health_num;
    }

    public String getBank_num() {
        return bank_num;
    }

    public void setBank_num(String bank_num) {
        this.bank_num = bank_num;
    }

    public String getCerti_num() {
        return certi_num;
    }

    public void setCerti_num(String certi_num) {
        this.certi_num = certi_num;
    }

    public String getVehicle_iden() {
        return vehicle_iden;
    }

    public void setVehicle_iden(String vehicle_iden) {
        this.vehicle_iden = vehicle_iden;
    }

    public String getDevice_iden() {
        return device_iden;
    }

    public void setDevice_iden(String device_iden) {
        this.device_iden = device_iden;
    }

    public String getLinkedln() {
        return linkedln;
    }

    public void setLinkedln(String linkedln) {
        this.linkedln = linkedln;
    }

    public String getInter_add() {
        return inter_add;
    }

    public void setInter_add(String inter_add) {
        this.inter_add = inter_add;
    }

    public String getNuid_num() {
        return nuid_num;
    }

    public void setNuid_num(String nuid_num) {
        this.nuid_num = nuid_num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", geo_data='" + geo_data + '\'' +
                ", dob='" + dob + '\'' +
                ", tele_num='" + tele_num + '\'' +
                ", fax_num='" + fax_num + '\'' +
                ", email_add='" + email_add + '\'' +
                ", ssn='" + ssn + '\'' +
                ", medi_num='" + medi_num + '\'' +
                ", health_num='" + health_num + '\'' +
                ", bank_num='" + bank_num + '\'' +
                ", certi_num='" + certi_num + '\'' +
                ", vehicle_iden='" + vehicle_iden + '\'' +
                ", device_iden='" + device_iden + '\'' +
                ", linkedln='" + linkedln + '\'' +
                ", inter_add='" + inter_add + '\'' +
                ", nuid_num='" + nuid_num + '\'' +
                ", icon_path='" + icon_path + '\'' +
                '}';
    }
}
