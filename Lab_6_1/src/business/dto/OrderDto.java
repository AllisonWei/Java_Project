package business.dto;

import java.util.UUID;

public class OrderDto {
    private String id;
    
    private String restaurantName;
    
    private String meal;
    
    private String deliveryName;
    
    private String userName;
    
    private String status;
    
    private String comment;

    public OrderDto(String restaurantName, String meal, String deliveryName, String userName, String status, String comment) {
        super();
        this.id = UUID.randomUUID().toString();
        this.restaurantName = restaurantName;
        this.meal = meal;
        this.deliveryName = deliveryName;
        this.userName = userName;
        this.status = status;
        this.comment = comment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
