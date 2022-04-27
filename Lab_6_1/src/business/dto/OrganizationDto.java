package business.dto;

public class OrganizationDto {
    private String orgnaizationName;
    
    public OrganizationDto(String orgnaizationName) {
        super();
        this.orgnaizationName = orgnaizationName;
    }

    public String getOrgnaizationName() {
        return orgnaizationName;
    }

    public void setOrgnaizationName(String orgnaizationName) {
        this.orgnaizationName = orgnaizationName;
    }
}
