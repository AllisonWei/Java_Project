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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author archil
 */
public class SupplierDirectory {

    private List<Supplier> supplierList;

    public SupplierDirectory() {
        supplierList = new ArrayList<Supplier>();
    }

    public List<Supplier> getSupplierlist() {
        return supplierList;
    }

    public Supplier addSupplier() {
        Supplier newSupplier = new Supplier();
        supplierList.add(newSupplier);
        return newSupplier;
    }
    
    public void addSupplier(Supplier supplier) {
    	for (Product p : supplier.getProductCatalog().getProductcatalog()) {
			addProduct(p);
		}
    }
    
    public void removeProduct(double num) {
    	for (Supplier supplier : supplierList) {
    		supplier.getProductCatalog().removeProduct(num);
		}
    }
    
    public void addProduct(Product p) {
    	for (Supplier s : supplierList) {
			if (p.getManu().equals(s.getSupplyName())) {
				s.addProduct(p);
				return;
			}
		}
    	Supplier supplier = addSupplier();
    	supplier.addProduct(p);
    	supplier.setSupplyName(p.getManu());
    }
    
    public Product findProductByName(String name) {
    	for (Supplier s : supplierList) {
    		Product p = null;
			if ((p = s.getProductCatalog().findProductByName(name)) != null) {
				return p;
			}
		}
    	return null;
    }
    
    public Product findProductByNumber(double num) {
    	for (Supplier s : supplierList) {
    		Product p = null;
			if ((p = s.getProductCatalog().findProductByNumber(num)) != null) {
				return p;
			}
		}
    	return null;
    }
    

    public void removeSupplier(Supplier s) {
        supplierList.remove(s);
    }

    public Supplier searchSupplier(String supplierName) {
        for (Supplier supplier : supplierList) {
            if (supplier.getSupplyName().equals(supplierName)) {
                return supplier;
            }
        }
        return null;
    }
    
    public Product findByNumber(double number){
    	Product result = null;
    	for (Supplier supplier : supplierList) {
			if ((result = supplier.findByNumber(number)) != null) {
		    	return result;
			}
		}
    	return result;
    }
    
    public List<Product> findByYear(int year){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByYear(year));
		}
    	return result;
    }
    
    public List<Product> findByCity(String city){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByCity(city));
		}
    	return result;
    }
    
    public List<Product> findBySeat(int s,int e){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findBySeat(s,e));
		}
    	return result;
    }
    
    public List<Product> findByModel(String model){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByModel(model));
		}
    	return result;
    }
    
    public List<Product> findByAvailable(){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByAvailable());
		}
    	return result;
    }
    
    public List<Product> findByUnAvailable(){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByUnAvailable());
		}
    	return result;
    }
    
    public List<Product> findByDate(String date){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByDate(date));
		}
    	return result;
    }
    
    public List<Product> findAll(){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findAll());
		}
    	return result;
    }
    
    public Supplier findAlls(){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findAll());
		}
    	Supplier s = new Supplier();
    	s.getProductCatalog().getProductcatalog().addAll(result);
    	return s;
    }
    
    public List<Product> findByMaun(String m){
    	List<Product> result = new ArrayList<Product>();
    	for (Supplier supplier : supplierList) {
    		result.addAll(supplier.findByManu(m));
		}
    	return result;
    }
}