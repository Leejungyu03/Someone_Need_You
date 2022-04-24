package com.SNY.resume.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SNY.resume.dao.ResumeCareerDAO;
import com.SNY.resume.model.ResumeCareer;

@Service
public class ResumeCareerBO {
	
	@Autowired
	private ResumeCareerDAO resumeCareerDAO;
	
	public List<ResumeCareer> getResumeCareerByResumeId(int resumeId) {
		return resumeCareerDAO.selectResumeCareerByResumeId(resumeId);
	}
	
	public int addResumeCareerByResumeId(int resumeId, String companyName, String startPeriod, String endPeriod, String task) {
		return resumeCareerDAO.insertResumeCareerByResumeId(resumeId, companyName, startPeriod, endPeriod, task);
	}
	
	public int deleteResumeCareerById(int resumeCareerId) {
		return resumeCareerDAO.deleteResumeCareerById(resumeCareerId);
	}
}
