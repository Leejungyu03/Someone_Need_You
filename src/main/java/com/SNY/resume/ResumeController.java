package com.SNY.resume;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SNY.resume.bo.ResumeBO;
import com.SNY.resume.bo.ResumeCareerBO;
import com.SNY.resume.bo.ResumeEducationBO;
import com.SNY.resume.model.Resume;
import com.SNY.resume.model.ResumeEducation;
import com.SNY.resume.model.ResumeCareer;

@RequestMapping("/resume")
@Controller
public class ResumeController {
	
	@Autowired
	private ResumeBO resumeBO;
	
	@Autowired
	private ResumeEducationBO resumeEducationBO;
	
	@Autowired
	private ResumeCareerBO resumecareerBO;
	
	@RequestMapping("/apply_list_view")
	public String applyListView() {
		return "/resume/apply_list";
	}
	
	@RequestMapping("/modify_view")
	public String modifyView(
			Model model,
			HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		
		Resume resume = resumeBO.getResumeEducationByUserId(userId);
		List<ResumeEducation> educationList = resumeEducationBO.getResumeEducationByResumeId(resume.getId());
		
		List<ResumeCareer> careerList = resumecareerBO.getResumeCareerByResumeId(resume.getId());
		
		model.addAttribute("educationList", educationList);
		model.addAttribute("careerList", careerList);
		
		return "/resume/modify";
	}
	
	@RequestMapping("/info_view")
	public String infoView() {
		return "/resume/info";
	}
}
