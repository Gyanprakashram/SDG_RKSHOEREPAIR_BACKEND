package com.rkshoesrepair.shoe.formcotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rkshoesrepair.shoe.formentityvo.SubmissionFormVo;
import com.rkshoesrepair.shoe.formservice.SubmissionFormService;

@RestController
@RequestMapping("/api/submissionform")
@CrossOrigin(origins = "*") 
public class SubmissionFormController {

    @Autowired
    private SubmissionFormService contactFormService;

    @PostMapping("/submit")
    public String submitContactForm(@RequestBody SubmissionFormVo submissionFormVo)
    {
    	System.out.println("contoeller caled");
       return contactFormService.saveFormData(submissionFormVo);
    }
}