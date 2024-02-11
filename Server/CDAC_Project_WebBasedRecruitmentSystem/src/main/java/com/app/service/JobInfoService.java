package com.app.service;

import com.app.payload.response.ApiResponse;

public interface JobInfoService {

	ApiResponse applyJobFun( Long jobId);

	ApiResponse unApplyJobFun(Long jobId);

}
