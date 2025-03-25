package com.rkshoesrepair.shoe.formservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rkshoesrepair.shoe.formentity.SubmissionFormEntity;
import com.rkshoesrepair.shoe.formentityvo.SubmissionFormVo;
import com.rkshoesrepair.shoe.formrepo.SubmissionFormRepo;

@Service
public class SubmissionFormServiceImpl implements SubmissionFormService 
{
	@Autowired
	SubmissionFormRepo submissionFormRepo;

	@Override
	public String saveFormData(SubmissionFormVo submissionFormVo)
	{
		try
		{
			SubmissionFormEntity subFormEntiry=new SubmissionFormEntity();
			subFormEntiry.setEmail(submissionFormVo.getEmail());
			subFormEntiry.setMessage(submissionFormVo.getMessage());
			subFormEntiry.setName(submissionFormVo.getName());
			subFormEntiry.setSubject(submissionFormVo.getSubject());
			submissionFormRepo.save(subFormEntiry);	
			return "DATA saved successfully";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "Exceptin found";
		}
	
	}

}
