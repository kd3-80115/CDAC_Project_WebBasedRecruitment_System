package com.app.service;

import org.springframework.security.core.Authentication;

import com.app.payload.response.AddressResp;

public interface AddressService {

	AddressResp getAddress(Authentication auth);

}
