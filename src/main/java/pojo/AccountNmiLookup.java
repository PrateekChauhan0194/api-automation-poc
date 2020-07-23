package pojo;

import java.util.List;

public class AccountNmiLookup {
    private String customerType;
    private String safetyQuestions = "UNKNOWN";
    private String postcode;
    private String nmi;
    private boolean addCurrentPlan;
    private String electricityAccountNumber;
    private List<String> qualifications;

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getNmi() {
        return nmi;
    }

    public void setNmi(String nmi) {
        this.nmi = nmi;
    }

    public boolean isAddCurrentPlan() {
        return addCurrentPlan;
    }

    public void setAddCurrentPlan(boolean addCurrentPlan) {
        this.addCurrentPlan = addCurrentPlan;
    }

    public String getElectricityAccountNumber() {
        return electricityAccountNumber;
    }

    public void setElectricityAccountNumber(String electricityAccountNumber) {
        this.electricityAccountNumber = electricityAccountNumber;
    }

    public List<String> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<String> qualifications) {
        this.qualifications = qualifications;
    }
}
