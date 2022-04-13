package com.SNY.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SNY.account.bo.UserBO;
import com.SNY.account.model.User;
import com.SNY.common.EncryptUtils;

@RestController
@RequestMapping("/user")
public class UserRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	
	@PutMapping("/mypage_modify")
	public Map<String, Object> myPageModify(
			@RequestParam("modifyUserId") String modifyUserId,
			@RequestParam(value = "modifyPassword" , required = false) String modifyPassword,
			@RequestParam("modifyEmail") String modifyEmail,
			@RequestParam("modifyName") String modifyName,
			HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		
		if (modifyPassword == "") {
			modifyPassword = null;
		} else {
			modifyPassword = EncryptUtils.md5(modifyPassword);
		}
		
		int row = userBO.modifyUserByUserId(userId, modifyUserId, modifyPassword, modifyEmail, modifyName);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			User user = userBO.getUserByUserId(userId);
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			result.put("result", "success");
		} else {
			result.put("result", "error");
			result.put("error_message", "정보 변경에 실패하였습니다.");
		}
		return result;
	}
	
	@DeleteMapping("/mypage_delete")
	public Map<String, Object> myPageDelete(HttpSession session) {
		
		int userId = (int) session.getAttribute("userId");
		
		int row = userBO.deleteUserByUserId(userId);
		
		Map<String, Object> result = new HashMap<>();
		if (row > 0) {
			result.put("result", "success");
			session.removeAttribute("userId");
			session.removeAttribute("userLoginId");
			session.removeAttribute("userName");
		} else {
			result.put("result", "error");
			result.put("error_message", "회원 탈퇴에 실패하였습니다.");
		}
		return result;
		
	}
}