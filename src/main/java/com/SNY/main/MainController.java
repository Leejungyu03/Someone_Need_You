package com.SNY.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/main")
@Controller
public class MainController {
	
	@RequestMapping("/notice_view")
	public String niticeView(
			Model model) {
		
		model.addAttribute("title", "전체 공고");
		model.addAttribute("viewName", "main/notice");
		
		return "template/layout";
	}
	
	@RequestMapping("/appropriate_view")
	public String appropriateView(
			Model model) {
		
		model.addAttribute("title", "나에게 맞는 공고");
		model.addAttribute("viewName", "main/appropriate");
		
		return "template/layout";
	}
	
	@RequestMapping("/company_list_view")
	public String companyListView(
			Model model) {
		
		model.addAttribute("title", "회사 목록");
		model.addAttribute("viewName", "main/company_list");
		
		return "template/layout";
	}
}
