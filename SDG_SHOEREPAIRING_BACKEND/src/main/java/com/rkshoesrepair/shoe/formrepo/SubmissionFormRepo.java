package com.rkshoesrepair.shoe.formrepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rkshoesrepair.shoe.formentity.SubmissionFormEntity;

@Repository
public interface SubmissionFormRepo extends JpaRepository<SubmissionFormEntity, Long>
{
   
}
