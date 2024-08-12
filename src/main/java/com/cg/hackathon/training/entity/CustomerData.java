package com.cg.hackathon.training.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Schema(description = "Customer Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerData {
    @JsonProperty("applicationID")
    @Hidden
    private String applicationID;
    @Id
    @JsonProperty("ssn")
    private String ssn;
    @Column
    @Schema(description = "firstName")
    @JsonProperty("firstName")
    private String firstName;
    @Column
    @Schema(description = "middleName")
    @JsonProperty("middleName")
    private String middleName;
    @Column
    @Schema(description = "lastName")
    @JsonProperty("lastName")
    private String lastName;
    @Column
    @Schema(description = "addressLine1")
    @JsonProperty("addressLine1")
    private String addressLine1;
    @Column
    @Schema(description = "addressLine2")
    @JsonProperty("addressLine2")
    private String addressLine2;
    @Column
    @Schema(description = "city")
    @JsonProperty("city")
    private String city;
    @Column
    @Schema(description = "state")
    @JsonProperty("state")
    private String state;
    @Column
    @Schema(description = "zipCode")
    @JsonProperty("zipCode")
    private String zipCode;
    @Column
    @Schema(description = "dob")
    @JsonProperty("dob")
    private String dob;
    @Column
    @Schema(description = "email")
    @JsonProperty("email")
    private String email;
    @Column
    @Schema(description = "phoneNumber")
    @JsonProperty("phoneNumber")
    private String phoneNumber;
    @Column
    @Schema(description = "mobileNumber")
    @JsonProperty("mobileNumber")
    private String mobileNumber;
    @Column
    @Schema(description = "annualIncome")
    @JsonProperty("annualIncome")
    private String annualIncome;
    @Column
    @Schema(description = "home")
    @JsonProperty("home")
    private String home;
    @Column
    @Schema(description = "employementStatus")
    @JsonProperty("employementStatus")
    private String employementStatus;
    @Column
    @Schema(description = "employmentType")
    @JsonProperty("employmentType")
    private String employmentType;
    @Column
    @Schema(description = "age")
    @JsonProperty("age")
    private int age;
    @Column
    @Schema(description = "amount")
    @JsonProperty("amount")
    private String amount;
    @Column
    @Schema(description = "duration")
    @JsonProperty("duration")
    private int duration;
    @Column
    @Schema(description = "productSelected")
    @JsonProperty("productSelected")
    private String productSelected;

    @Hidden
    private String creditDecision;

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(String annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getEmployementStatus() {
        return employementStatus;
    }

    public void setEmployementStatus(String employementStatus) {
        this.employementStatus = employementStatus;
    }

    public String getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(String employmentType) {
        this.employmentType = employmentType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getProductSelected() {
        return productSelected;
    }

    public void setProductSelected(String productSelected) {
        this.productSelected = productSelected;
    }

    public String getCreditDecision() {
        return creditDecision;
    }

    public void setCreditDecision(String creditDecision) {
        this.creditDecision = creditDecision;
    }
}
