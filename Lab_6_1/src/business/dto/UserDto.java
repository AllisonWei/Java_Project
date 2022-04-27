package business.dto;

import java.util.UUID;

public class UserDto {
    private String id;
    
    private String userName;
    
    private String password;
    
    private RoleDto role;
    
    private OrganizationDto organization;
    
    private PersonDto person;
    
    private String restaurantName;

    public UserDto(String userName, String password, RoleDto role, OrganizationDto organization,
        PersonDto person) {
        super();
        this.id = UUID.randomUUID().toString();
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.organization = organization;
        this.person = person;
    }
    
    public UserDto(String userName, String password, RoleDto role, OrganizationDto organization, PersonDto person,
        String restaurantName) {
        super();
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.organization = organization;
        this.person = person;
        this.restaurantName = restaurantName;
        this.id = UUID.randomUUID().toString();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleDto getRole() {
        return role;
    }

    public void setRole(RoleDto role) {
        this.role = role;
    }

    public OrganizationDto getOrganization() {
        return organization;
    }

    public void setOrganization(OrganizationDto organization) {
        this.organization = organization;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Override
    public String toString() {
        return getRestaurantName();
    }
}
