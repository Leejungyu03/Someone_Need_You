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
	
	public User getUserByUserId(int userId) {
		return userDAO.selectUserByUserId(userId);
	}
	
	public User getUserByLoginIdAndPassword(String loginId, String password) {
		return userDAO.selectUserByLoginIdAndPassword(loginId, password);
	}
	
	
	public int addSignUpUser(String loginId, String password, String email, String name) {
		return userDAO.insertSignUpUser(loginId, password, email, name);
	}
	
	public int modifyUserByUserId(int userId, String modifyUserId, String modifyPassword, String modifyEmail, String modifyName) {
		return userDAO.updateUserByUserId(userId, modifyUserId, modifyPassword, modifyEmail, modifyName);
	}
	
	public int deleteUserByUserId(int userId) {
		return userDAO.deleteUserByUserId(userId);
	}

	
}
