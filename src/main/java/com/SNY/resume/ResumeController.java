package com.SNY.resume;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/resume")
@Controller
public class ResumeController {
	
	@RequestMapping("/apply_list_view")
	public String applyListView() {
		return "/resume/apply_list";
	}
	
	@RequestMapping("/modify_view")
	public String modifyView() {
		return "/resume/modify";
	}
	
	@RequestMapping("/info_view")
	public String infoView() {
		return "/resume/info";
	}
}
