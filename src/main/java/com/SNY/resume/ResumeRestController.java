package com.SNY.resume;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SNY.resume.bo.ResumeBO;
import com.SNY.resume.bo.ResumeCareerBO;
import com.SNY.resume.bo.ResumeEducationBO;
import com.SNY.resume.model.Resume;

@RequestMapping("/resume")
@RestController
public class ResumeRestController {
	
	@Autowired
	private ResumeBO resumeBO;
	
	@Autowired
	private ResumeEducationBO resumeEducationBO;
	
	@Autowired
	private ResumeCareerBO resumeCareerBO;
	
	/**
	 * 이력서 초기 셋팅하기
	 * @param session
	 * @return
	 */
	@PostMapping("/add")
	public Map<String, Object> add(HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		
		resumeBO.confirmResumeByUserId(userId);
		
		return null;
	}
	
	/**
	 * 이력서 아이디 구하기
	 * @param session
	 * @return
	 */
	@PostMapping("/find_resumeId")
	public Map<String, Object> findResumeId(HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		
		Resume resume = resumeBO.getResumeEducationByUserId(userId);
		Map<String, Object> result = new HashMap<>();
		
		result.put("resumeId", resume.getId());
		
		return result;
	}
	
	@PostMapping("/education_create")
	public Map<String, Object> educationCreate(
			@RequestParam("resumeId") int resumeId,
			@RequestParam("classification") String classification,
			@RequestParam("name") String name, 
			@RequestParam("graduation") String graduation) {
		
		int row = resumeEducationBO.addResumeEducationByResumeId(resumeId, classification, name, graduation);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
		}
		
		return result;
	}
	
	@DeleteMapping("/education_delete")
	public Map<String, Object> educationDelete(
			@RequestParam("resumeEducationId") int resumeEducationId) {
		
		int row = resumeEducationBO.deleteResumeEducationById(resumeEducationId);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("result", "success");
		}
		
		return result;
	}
	
	@PostMapping("/career_create")
	public Map<String, Object> careerCreate(
			@RequestParam("resumeId") int resumeId,
			@RequestParam("companyName") String companyName,
			@RequestParam("startPeriod") String startPeriod, 
			@RequestParam("endPeriod") String endPeriod,
			@RequestParam("task") String task) {
		
		int row = resumeCareerBO.addResumeCareerByResumeId(resumeId, companyName, startPeriod, endPeriod, task);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("result", "success");
		} else {
			result.put("result", "error");
		}
		
		return result;
	}
	
	@DeleteMapping("/career_delete")
	public Map<String, Object> careerDelete(
			@RequestParam("resumeCareerId") int resumeCareerId) {
		
		int row = resumeCareerBO.deleteResumeCareerById(resumeCareerId);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("result", "success");
		}
		
		return result;
	}
}
