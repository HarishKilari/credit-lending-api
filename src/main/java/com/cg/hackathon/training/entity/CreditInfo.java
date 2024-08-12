package com.cg.hackathon.training.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Entity
@Schema(description = "Credit Information")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="credit_history")
public class CreditInfo implements Serializable {

    @Id
    private String ssn;
    @Column(name = "credit_score")
    private int creditScore;
    @Column(name = "debt_income")
    private double debtToIncomeRatio;
    @Column(name = "missed_payment_history")
    private int missedPaymentHistory;
    @Column(name = "credit_utilization")
    private double creditUtilization;
    @Column(name = "credit_history_length")
    private int creditHistoryLength;
    @Column(name = "recent_credit_inquiries")
    private int recentCreditInquiries;
    @Column(name = "existing_credit_products")
    private int existingCreditProducts;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public double getDebtToIncomeRatio() {
        return debtToIncomeRatio;
    }

    public void setDebtToIncomeRatio(double debtToIncomeRatio) {
        this.debtToIncomeRatio = debtToIncomeRatio;
    }

    public int getMissedPaymentHistory() {
        return missedPaymentHistory;
    }

    public void setMissedPaymentHistory(int missedPaymentHistory) {
        this.missedPaymentHistory = missedPaymentHistory;
    }

    public double getCreditUtilization() {
        return creditUtilization;
    }

    public void setCreditUtilization(double creditUtilization) {
        this.creditUtilization = creditUtilization;
    }

    public int getCreditHistoryLength() {
        return creditHistoryLength;
    }

    public void setCreditHistoryLength(int creditHistoryLength) {
        this.creditHistoryLength = creditHistoryLength;
    }

    public int getRecentCreditInquiries() {
        return recentCreditInquiries;
    }

    public void setRecentCreditInquiries(int recentCreditInquiries) {
        this.recentCreditInquiries = recentCreditInquiries;
    }

    public int getExistingCreditProducts() {
        return existingCreditProducts;
    }

    public void setExistingCreditProducts(int existingCreditProducts) {
        this.existingCreditProducts = existingCreditProducts;
    }
}