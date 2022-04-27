package business.type;

public enum RoleType {
    RestaurantAdmin("RestaurantAdmin"), 
    Customer("Customer"), 
    DeliveryMan("DeliveryMan"), 
    SysAdmin("Sysadmin");

    private String value;

    private RoleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
