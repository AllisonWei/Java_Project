package business.dto;

import java.util.UUID;

public class RestaurantMenuDto {
    private String id;
    
    private String relId;
    
    private String meal;
    
    private String price;

    public RestaurantMenuDto(String relId, String meal, String price) {
        super();
        this.id = UUID.randomUUID().toString();
        this.relId = relId;
        this.meal = meal;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelId() {
        return relId;
    }

    public void setRelId(String relId) {
        this.relId = relId;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
