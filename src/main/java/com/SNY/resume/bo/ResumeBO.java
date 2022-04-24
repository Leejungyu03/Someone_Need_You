package com.SNY.resume.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SNY.resume.dao.ResumeDAO;
import com.SNY.resume.model.Resume;

@Service
public class ResumeBO {
	@Autowired
	private ResumeDAO resumeDAO;
	
	// userId와 일치하는 Resume의 존재 여부 확인
	public int existResumeByUserId(int userId) {
		return resumeDAO.existResumeByUserId(userId);
	}
	
	// userId로 Resume 가져오기
	public Resume getResumeEducationByUserId(int userId) {
		return resumeDAO.selectResumeByUserId(userId);
	}
	
	// userId로 Resume 초기 생성
	public int addEarlyResumeByUserId(int userId) {
		return resumeDAO.insertEarlyResumeByUserId(userId);
	}
	
	// 같은 userId를 가진 Resume이 있는지 확인하고 그에 맞게 실행
	public int confirmResumeByUserId(int userId) {
		
		int row = existResumeByUserId(userId);
		if (row > 0) {
			return 0;	// 같은 userId를 가진 Resume이 이미 있다
		} else {
			return addEarlyResumeByUserId(userId);	// 같은 userId를 가진 Resume이 없다. 등록한다.
		}
		
	}
}
