package com.SNY.resume.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SNY.resume.dao.ResumeEducationDAO;
import com.SNY.resume.model.ResumeEducation;

@Service
public class ResumeEducationBO {
	
	@Autowired
	private ResumeEducationDAO resumeEducationDAO;
	
	// resumeId와 같은 Resume Education들 출력
	public List<ResumeEducation> getResumeEducationByResumeId(int resumeId) {
		return resumeEducationDAO.selectResumeEducationByResumeId(resumeId);
	}
	
	// resumeId와 같은 행에 Resume Education 입력
	public int addResumeEducationByResumeId(int resumeId, String classification, String name, String graduation) {
		return resumeEducationDAO.insertResumeEducationByResumeId(resumeId, classification, name, graduation);
	}
	
	// resumeId와 같은 행에 Resume Education 삭제
	public int deleteResumeEducationById(int resumeEducationId) {
		return resumeEducationDAO.deleteResumeEducationById(resumeEducationId);
	}
	
	
}
