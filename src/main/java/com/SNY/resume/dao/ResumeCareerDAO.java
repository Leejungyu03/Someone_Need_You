package com.SNY.resume.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SNY.resume.model.ResumeCareer;

@Repository
public interface ResumeCareerDAO {
	
	public List<ResumeCareer> selectResumeCareerByResumeId(int resumeId);
	
	public int insertResumeCareerByResumeId(
			@Param("resumeId") int resumeId,
			@Param("companyName") String companyName,
			@Param("startPeriod") String startPeriod,
			@Param("endPeriod") String endPeriod,
			@Param("task") String task);
	
	public int deleteResumeCareerById(int resumeCareerId);

}
