package com.SNY.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@RequestMapping("/mypage_view")
	public String myPageView(Model model) {
		
		model.addAttribute("viewName", "user/mypage");
		return "template/layout";
	}
}
