package com.SNY.account;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/account")
@Controller
public class AccountController {
	
	@RequestMapping("/sign_up_view")
	public String signUpView() {
		return "account/sign_up";
	}
	
	@RequestMapping("/sign_in_view")
	public String signInView() {
		return "account/sign_in";
	}
	
	@RequestMapping("/sign_out_user")
	public String userSignOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 로그아웃 할때 모든것을 비워야함
		session.removeAttribute("userId");
		session.removeAttribute("userLoginId");
		session.removeAttribute("userName");
		
		return "redirect:/account/sign_in_view";
	}
	
	@RequestMapping("/sign_out_company")
	public String companySignOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		// 로그아웃 할때 모든것을 비워야함
		session.removeAttribute("companyId");
		session.removeAttribute("companyLoginId");
		session.removeAttribute("companyName");
		
		return "redirect:/account/sign_in_view";
	}
}
