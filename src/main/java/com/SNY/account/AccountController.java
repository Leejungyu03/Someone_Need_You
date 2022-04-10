package com.SNY.account;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
@Controller
public class AccountController {
	
	@RequestMapping("/sign_up_view")
	public String signUpView(
			Model model) {
		
		
		return "account/sign_up";
	}
	
	@RequestMapping("/sign_in_view")
	public String signInView(
			Model model) {
		
		
		return "account/sign_in";
	}
}
