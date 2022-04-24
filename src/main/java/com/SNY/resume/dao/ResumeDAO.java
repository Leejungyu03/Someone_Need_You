package com.SNY.resume.dao;

import org.springframework.stereotype.Repository;

import com.SNY.resume.model.Resume;

@Repository
public interface ResumeDAO {
	
	// userId와 일치하는 Resume의 존재 여부 확인
	public int existResumeByUserId(int userId);
	
	// userId로 Resume 가져오기
	public Resume selectResumeByUserId(int userId);
	
	// 초기에 userId로 Resume 초기 생성
	public int insertEarlyResumeByUserId(int userId);
	
}
