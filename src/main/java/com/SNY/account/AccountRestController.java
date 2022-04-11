package com.SNY.account;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SNY.account.bo.CompanyBO;
import com.SNY.account.bo.UserBO;
import com.SNY.account.model.Company;
import com.SNY.account.model.User;
import com.SNY.common.EncryptUtils;

@RequestMapping("/account")
@RestController
public class AccountRestController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CompanyBO companyBO;
	
	/**
	 * User 아이디 중복 확인
	 * @param loginId
	 * @return
	 */
	@PostMapping("/is_duplicated_user")
 	public Map<String, Object> isDuplicatedUser(
 			@RequestParam("loginId") String loginId) {
		
		int row = userBO.existUserByLoginId(loginId);
		Map<String, Object> result = new HashMap<>();
		
		if (row > 0) {
			result.put("result", true); // 중복 일때
		} else {
			result.put("result", false); // 중복 아닐때
		}
		
		
		return result;
	}
	
	/**
	 * User 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @return
	 */
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
	
	/**
	 * Company 아이디 중복 확인
	 * @param loginId
	 * @return
	 */
	@PostMapping("/is_duplicated_company")
 	public Map<String, Object> isDuplicatedCompany(
 			@RequestParam("loginId") String loginId) {
		
		int row = companyBO.existCompanyByLoginId(loginId);
		Map<String, Object> result = new HashMap<>();
		
		if (row > 0) {
			result.put("result", true); // 중복 일때
		} else {
			result.put("result", false); // 중복 아닐때
		}
		
		
		return result;
	}
	
	/**
	 * Company 회원가입
	 * @param loginId
	 * @param password
	 * @param name
	 * @param email
	 * @return
	 */
	@PostMapping("/sign_up_company")
	public Map<String, Object> signUpCompany(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("email") String email) {
		
		String encryptPassword = EncryptUtils.md5(password);
		
		int row = companyBO.addSignUpCompany(loginId, encryptPassword, name, email);
		Map<String, Object> result = new HashMap<>();
		
		result.put("result", "success");
		if (row < 1) {
			result.put("result", "error");
		}
		
		return result;
	}
	
	@PostMapping("/sign_in_user")
	public Map<String, Object> signInUser(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		
		HttpSession session =  request.getSession();
		String encryptPassword = EncryptUtils.md5(password);
		
		User user = userBO.getUserByLoginIdAndPassword(loginId, encryptPassword);
		Map<String, Object> result = new HashMap<>();
		if (user != null) {
			session.setAttribute("userId", user.getId());
			session.setAttribute("userLoginId", user.getLoginId());
			session.setAttribute("userName", user.getName());
			result.put("result", "success");
			result.put("userName", user.getName());
		} else {
			result.put("result", "error");
			result.put("error_message", "잘못된 아이디 또는  패스워드입니다.");
		}
		
		return result;
	}
	
	@PostMapping("/sign_in_company")
	public Map<String, Object> signInCompany(
			@RequestParam("loginId") String loginId,
			@RequestParam("password") String password,
			HttpServletRequest request) {
		
		HttpSession session =  request.getSession();
		String encryptPassword = EncryptUtils.md5(password);
		
		Company company = companyBO.getCompanyByLoginIdAndPassword(loginId, encryptPassword);
		
		Map<String, Object> result = new HashMap<>();
		if (company != null) {
			session.setAttribute("companyId", company.getId());
			session.setAttribute("companyLoginId", company.getLoginId());
			session.setAttribute("companyName", company.getName());
			result.put("result", "success");
			result.put("companyName", company.getName());
		} else {
			result.put("result", "error");
			result.put("error_message", "잘못된 아이디 또는  패스워드입니다.");
		}
		
		return result;
	}
}
