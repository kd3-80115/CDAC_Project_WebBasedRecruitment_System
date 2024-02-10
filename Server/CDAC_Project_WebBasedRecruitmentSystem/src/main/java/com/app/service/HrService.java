package com.app.service;

import com.app.payload.request.HrRequest;
import com.app.payload.response.ApiResponse;
import com.app.payload.response.HrResponse;

public interface HrService {

	//get HR whole details
	public HrResponse getHrDetails();
	
	//update the hr details password etc
	public ApiResponse updateHr(HrRequest hr);
		 
}
