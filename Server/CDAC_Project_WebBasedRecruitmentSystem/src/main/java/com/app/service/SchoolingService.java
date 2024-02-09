package com.app.service;

import com.app.payload.response.SchoolingResponse;

public interface SchoolingService {
	SchoolingResponse getSchooling(Long applicantId);
}
