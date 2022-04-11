package com.SNY.account.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public int isDuplicatedByLoginId(String loginId);
	
	public int insertSignUpUser(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("email") String email,
			@Param("name") String name);
}
