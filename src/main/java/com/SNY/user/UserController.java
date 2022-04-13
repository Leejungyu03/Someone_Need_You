package com.SNY.user;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SNY.account.bo.UserBO;
import com.SNY.account.model.User;

@RequestMapping("/user")
@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	
	@RequestMapping("/mypage_view")
	public String myPageView(
			Model model,
			HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		String userName = (String) session.getAttribute("userName");
		// 로그인 여부 검사
		if (userName == null) {
			return "redirect:/account/sign_in_view";
		}
		
		User user = userBO.getUserByUserId(userId);
		
		model.addAttribute("user", user);
		model.addAttribute("viewName", "user/mypage");
		model.addAttribute("title", "마이페이지");
		return "template/layout";
	}
}
