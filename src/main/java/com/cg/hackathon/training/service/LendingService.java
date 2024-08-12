package com.cg.hackathon.training.service;

import com.cg.hackathon.training.entity.CreditInfo;
import com.cg.hackathon.training.entity.CustomerData;
import com.cg.hackathon.training.entity.Prediction;
import com.cg.hackathon.training.entity.PredictionResponse;
import com.cg.hackathon.training.repository.CustomerRepository;
import com.cg.hackathon.training.repository.LendingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@Transactional
public class LendingService {

    @Autowired
    private LendingRepository lendingRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public String predictCreditRisk(CustomerData customerData) throws Exception {

        customerRepository.save(customerData);
        CreditInfo credit = lendingRepository.findBySsn(customerData.getSsn());
        List<Map<String, Object>> instances = new ArrayList<>();

        // Instance 1
        Map<String, Object> instance1 = new HashMap<>();
        instance1.put("Product", customerData.getProductSelected());
        instance1.put("Credit_Score", Integer.toString(credit.getCreditScore()));
        instance1.put("DebttoIncome_Ratio", Double.toString(credit.getDebtToIncomeRatio()));
        instance1.put("Missed_Payment_History", Integer.toString(credit.getMissedPaymentHistory()));
        instance1.put("Credit_Utilization", Double.toString(credit.getCreditUtilization()));
        instance1.put("Credit_History_Length_in_months", Integer.toString(credit.getCreditHistoryLength()));
        instance1.put("Recent_Credit_Inquiries", Integer.toString(credit.getRecentCreditInquiries()));
        instance1.put("Existant_Credit_Products", Integer.toString(credit.getExistingCreditProducts()));
        instance1.put("Annual_Income", customerData.getAnnualIncome());
        instance1.put("Employment_Status", customerData.getEmployementStatus());
        instance1.put("Employment_Type", customerData.getEmploymentType());
        instance1.put("Age", Integer.toString(customerData.getAge()));
        if(null == customerData.getAmount() && StringUtils.isEmpty(customerData.getAmount())) {
            instance1.put("Amount", "0");
        }else {
            instance1.put("Amount", customerData.getAmount());
        }

        instances.add(instance1);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("instances", instances);

        String requestBodyJson = objectMapper.writeValueAsString(requestBody);
        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, requestBodyJson);
        String token = System.getenv("token");
        Request request = new Request.Builder()
                .url("https://us-central1-aiplatform.googleapis.com/v1/projects/194694415919/locations/us-central1/endpoints/3960174801435230208:predict")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + token)
                .build();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();
        PredictionResponse predictResponse = objectMapper.readValue(responseBody, PredictionResponse.class);
        boolean status = shouldApprove(predictResponse);
        if(status) {
            return "approved";
        }else {
            if(null == predictResponse.getPredictions()){
                System.out.println("No predictions found. Please check token config or Vertex API connection");
            }
            return "declined";
        }

    }

    public static boolean shouldApprove(PredictionResponse predictResponse) {
        List<Prediction> predictions = predictResponse.getPredictions();

        if (predictions != null && !predictions.isEmpty()) {
            Prediction prediction = predictions.get(0); // Assuming there's only one prediction
            List<String> classes = prediction.getClasses();
            List<Double> scores = prediction.getScores();

            int approvedIndex = classes.indexOf("Approved");
            if (approvedIndex != -1) {
                double approvedScore = scores.get(approvedIndex);
                return approvedScore >= 0.7;
            }
        }
        return false;
    }

    public String saveCustomerData(CustomerData customerData, String status) {
        customerData.setApplicationID(UUID.randomUUID().toString());
        customerData.setCreditDecision(status);
        customerRepository.save(customerData);
        return "Customer data saved successfully";
    }
}