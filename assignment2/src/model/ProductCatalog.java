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
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author archil
 */
public class ProductCatalog {

    private List<Product> productCatalog;

    public ProductCatalog() {
        productCatalog = new ArrayList<Product>();
    }

    public List<Product> getProductcatalog() {
        return productCatalog;
    }

    public Product addProduct() {
        Product p = new Product();
        productCatalog.add(p);
        return p;
    }
    
    public void addProduct(Product p) {
        productCatalog.add(p);
    }
    
    public void removeProduct(Product p) {
        productCatalog.remove(p);
    }
    
    public void removeProduct(double num) {
    	Iterator<Product> iterator = productCatalog.listIterator(0);
    	while(iterator.hasNext()) {
    		Product product = iterator.next();
    		if (num == product.getSerialNumber()) {
    			iterator.remove();
    			return;
    		}
    	}
    }

    public Product searchProduct(int id) {
        for (Product product : productCatalog) {
            if (product.getSerialNumber() == id) {
                return product;
            }
        }
        return null;
    }
    
    public Product findProductByName(String name) {
    	for (Product product : productCatalog) {
            if (product.getCarName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    
    public Product findProductByNumber(double number) {
    	for (Product product : productCatalog) {
            if (product.getSerialNumber() == number) {
                return product;
            }
        }
        return null;
    }
}
