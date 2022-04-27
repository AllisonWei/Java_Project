package business.dto;

public class PersonDto {
    private String personName;
    
    public PersonDto(String personName) {
        super();
        this.personName = personName;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
}
