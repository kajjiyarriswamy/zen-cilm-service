package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.CustomerKycRejectResponseDto;
import com.zenbank.cilm.dto.CustomerKycRequestDto;

public interface CustomerKycRejectService {

	CustomerKycRejectResponseDto rejectKyc(Long customerId, CustomerKycRequestDto requestDto);
}