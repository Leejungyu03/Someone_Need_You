package com.SNY.account.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SNY.account.model.Company;

@Repository
public interface CompanyDAO {
	
	public int existCompanyByLoginId(String loginId);
	
	public Company selectCompanyByLoginIdAndPassword(
			@Param("loginId") String loginId,
			@Param("password") String password);
	
	public int selectSignUpCompany(
			@Param("loginId") String loginId,
			@Param("password") String password,
			@Param("name") String name,
			@Param("email")String email);

}
