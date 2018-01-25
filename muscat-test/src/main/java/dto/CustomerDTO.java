package dto;

public class CustomerDTO {
    private final String companyName;

    public CustomerDTO(String companyName){
        this.companyName=companyName;
    }

    public String getCompanyName() {return companyName;}
}
