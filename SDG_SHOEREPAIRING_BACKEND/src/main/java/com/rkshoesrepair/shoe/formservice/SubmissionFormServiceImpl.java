package com.rkshoesrepair.shoe.formservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.JsonObject;
import com.rkshoesrepair.shoe.formentity.SubmissionFormEntity;
import com.rkshoesrepair.shoe.formentityvo.SubmissionFormVo;
import com.rkshoesrepair.shoe.formrepo.SubmissionFormRepo;

@Service
public class SubmissionFormServiceImpl implements SubmissionFormService {

    @Autowired
    SubmissionFormRepo submissionFormRepo;

    @Override
    public String saveFormData(SubmissionFormVo submissionFormVo) {
        JsonObject result = new JsonObject(); // Creating JSON response object
        
        try {
            // ✅ Input Validations
            if (submissionFormVo == null) {
                result.addProperty("error", "Invalid form data.");
                return result.toString();
            }

            if (submissionFormVo.getName() == null || submissionFormVo.getName().trim().isEmpty()) {
                result.addProperty("error", "Name cannot be empty.");
                return result.toString();
            }

            if (submissionFormVo.getEmail() == null || submissionFormVo.getEmail().trim().isEmpty()) {
                result.addProperty("error", "Email cannot be empty.");
                return result.toString();
            }

            if (!submissionFormVo.getEmail().contains("@")) {
                result.addProperty("error", "Invalid email format.");
                return result.toString();
            }

            if (submissionFormVo.getSubject() == null || submissionFormVo.getSubject().trim().isEmpty()) {
                result.addProperty("error", "Subject cannot be empty.");
                return result.toString();
            }

            if (submissionFormVo.getMessage() == null || submissionFormVo.getMessage().trim().isEmpty()) {
                result.addProperty("error", "Message cannot be empty.");
                return result.toString();
            }
     
            // ✅ Save the data
            SubmissionFormEntity subFormEntity = new SubmissionFormEntity();
            subFormEntity.setName(submissionFormVo.getName().trim());
            subFormEntity.setEmail(submissionFormVo.getEmail().trim());
            subFormEntity.setSubject(submissionFormVo.getSubject().trim());
            subFormEntity.setMessage(submissionFormVo.getMessage().trim());

            submissionFormRepo.save(subFormEntity);
            
            result.addProperty("message", "Data saved successfully");
            return result.toString();
        } 
        catch (Exception e) {
            e.printStackTrace();
            result.addProperty("error", "Exception occurred while saving data");
            return result.toString();
        }
    }
}
