package com.SNY.account;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SNY.account.bo.UserBO;
import com.SNY.common.EncryptUtils;

@RequestMapping("/account")
@RestController
public class AccountRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	
	@PostMapping("/is_duplicated_user")
 	public Map<String, Object> isDuplicatedUser(
 			@RequestParam("loginId") String loginId) {
		
		int row = userBO.isDuplicatedByLoginId(loginId);
		Map<String, Object> result = new HashMap<>();
		
		if (row > 0) {
			result.put("result", true); // 중복 일때
		} else {
			result.put("result", false); // 중복 아닐때
		}
		
		
		return result;
	}
	
	@PostMapping("/sign_up_user")
	public Map<String, Object> signUpUser(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		int row = userBO.addSignUpUser(loginId, encryptPassword, email, name);
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("result", "success");
		if (row < 1) {
			result.put("result", "error");
		}
		
		return result;
	}
	
	@PostMapping("/is_duplicated_company")
 	public Map<String, Object> isDuplicatedCompany(
 			@RequestParam("loginId") String loginId) {
		
		int row = 
		Map<String, Object> result = new HashMap<>();
		
		if (row > 0) {
			result.put("result", true); // 중복 일때
		} else {
			result.put("result", false); // 중복 아닐때
		}
		
		
		return result;
	}
	
	@PostMapping("/sign_up_company")
	public Map<String, Object> signUpCompany(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		int row = 
		
		Map<String, Object> result = new HashMap<>();
		
		result.put("result", "success");
		if (row < 1) {
			result.put("result", "error");
		}
		
		return result;
	}
}
