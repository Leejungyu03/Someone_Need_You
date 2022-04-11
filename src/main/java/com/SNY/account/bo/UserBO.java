package com.SNY.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SNY.account.dao.UserDAO;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int isDuplicatedByLoginId(String loginId) {
		return userDAO.isDuplicatedByLoginId(loginId);
	}
	
	public int addSignUpUser(String loginId, String password, String email, String name) {
		return userDAO.insertSignUpUser(loginId, password, email, name);
	}
}
