package com.SNY.account.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SNY.account.model.User;

@Repository
public interface UserDAO {

	public int existUserByLoginId(String loginId);
	
	public User selectUserByUserId(int userId);
	
	public User selectUserByLoginIdAndPassword(
			@Param("loginId") String loginId,
			@Param("password") String password);
	
	
	public int insertSignUpUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("email") String email,
			@Param("name") String name);
	
	public int updateUserByUserId(
			@Param("userId") int userId,
			@Param("modifyUserId") String modifyUserId,
			@Param("modifyPassword") String modifyPassword,
			@Param("modifyEmail") String modifyEmail,
			@Param("modifyName") String modifyName);
	
	public int deleteUserByUserId(int userId);
}
