package com.app.service;

import org.springframework.security.core.Authentication;

import com.app.payload.response.SchoolingResponse;

public interface SchoolingService {
	SchoolingResponse getSchooling(Authentication auth);
}
