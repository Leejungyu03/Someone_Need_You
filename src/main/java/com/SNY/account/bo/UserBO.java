package com.SNY.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SNY.account.dao.UserDAO;
import com.SNY.account.model.User;

@Service
public class UserBO {
	
	@Autowired
	private UserDAO userDAO;
	
	public int existUserByLoginId(String loginId) {
		return userDAO.existUserByLoginId(loginId);
	}
	
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdAndPassword(loginId, password);
	}
	
	public int addSignUpUser(String loginId, String password, String email, String name) {
		return userDAO.insertSignUpUser(loginId, password, email, name);
	}
	
}
