package business.type;

public enum OrganizationType {
    Admin("Admin Organization"), 
    Restaurant("Restaurant Organization"), 
    Customer("Customer Organization"),
    Delivery("Delivery Organization");

    private String value;

    private OrganizationType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
