/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Lynn Wei
 */
public class Supplier {
    private String supplyName;
    private ProductCatalog productCatalog;
    SimpleDateFormat aDate=new SimpleDateFormat("yyyyMMdd");

    public Supplier() {
        productCatalog = new ProductCatalog();
    }

    public String getSupplyName() {
        return supplyName;
    }

    public void setSupplyName(String supplyName) {
        this.supplyName = supplyName;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }
    
    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    
    public void addProduct(Product p) {
    	this.productCatalog.addProduct(p);
    }

    @Override
    public String toString() {
        return supplyName; 
    }
    
    public Product findByNumber(double number){
    	for (Product p : productCatalog.getProductcatalog()) {
			if (p.getSerialNumber() == number) {
				return p;
			}
		}
    	return null;
    }
    
    public List<Product> findByYear(int year){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if (p.getYear() == year) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findByCity(String city){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if (p.getCity().equals(city)) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findBySeat(int s,int e){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if (p.getSeat() >= s && p.getSeat() <= e) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findByModel(String m){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if (p.getModelNumber().equals(m)) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findByManu(String m){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if (p.getManu().equals(m)) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findByAvailable(){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if ("available".equals(p.getAvail())) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findByUnAvailable(){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
			if ("unavailable".equals(p.getAvail())) {
				result.add(p);
			}
		}
    	return result;
    }
    
    public List<Product> findByDate(String date){
    	ArrayList<Product> result = new ArrayList<Product>();
        for (Product p : productCatalog.getProductcatalog()) {
    		try {
				if (aDate.parse(date).compareTo(aDate.parse(p.getCertificate()))  == 1) {
					result.add(p);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
    	}
    	return result;
    }
    
    public List<Product> findAll(){
    	ArrayList<Product> result = new ArrayList<Product>();
    	for (Product p : productCatalog.getProductcatalog()) {
    		result.add(p);
		}
    	return result;
    }
}
