package com.app.service;

import com.app.payload.response.ApiResponse;

public interface AppliedJobService {
	
	//update job status
	ApiResponse updateStatusFun(Long jobId, String status);
}
