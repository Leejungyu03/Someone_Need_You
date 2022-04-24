package com.SNY.resume.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.SNY.resume.model.ResumeEducation;

@Repository
public interface ResumeEducationDAO {
	
	// resumeId와 같은 Resume Education들 출력
	public List<ResumeEducation> selectResumeEducationByResumeId(int resumeId);
	
	// resumeId와 같은 테이블에 Resume Education 입력
	public int insertResumeEducationByResumeId(
			@Param("resumeId") int resumeId,
			@Param("classification") String classification,
			@Param("name") String name,
			@Param("graduation") String graduation);
	
	// resumeId와 같은 행에 Resume Education 삭제
	public int deleteResumeEducationById(int resumeEducationId);
}
