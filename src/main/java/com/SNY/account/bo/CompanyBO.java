package com.SNY.account.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SNY.account.dao.CompanyDAO;
import com.SNY.account.model.Company;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyDAO companyDAO;
	
	public int existCompanyByLoginId(String loginId) {
		return companyDAO.existCompanyByLoginId(loginId);
	}
	
	public Company getCompanyByLoginIdAndPassword(String loginId, String password) {
		return companyDAO.selectCompanyByLoginIdAndPassword(loginId, password);
	}
	
	public int addSignUpCompany(String loginId, String password, String name, String email) {
		return companyDAO.selectSignUpCompany(loginId, password, name, email);
	}

}
