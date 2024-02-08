package com.app.service;

import com.app.payload.response.GetAddressResp;

public interface AddressService {

	GetAddressResp getAddress(Long applicantId);

}
