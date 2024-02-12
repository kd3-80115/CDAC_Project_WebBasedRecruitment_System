package com.app.service;

import java.util.List;

import com.app.entities.JobInfoEntity;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.JobInfoDetailsResponse;

public interface JobInfoService {

	ApiResponse applyJobFun( Long jobId);

	ApiResponse unApplyJobFun(Long jobId);

	List<JobInfoDetailsResponse> getAppliedJobFun();

}
