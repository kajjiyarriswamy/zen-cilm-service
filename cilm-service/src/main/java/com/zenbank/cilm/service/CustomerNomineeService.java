package com.zenbank.cilm.service;

import com.zenbank.cilm.dto.CustomerNomineeRequestDto;
import com.zenbank.cilm.dto.CustomerNomineeResponseDto;

public interface CustomerNomineeService {
    CustomerNomineeResponseDto addNominee(
            String customerId,
            CustomerNomineeRequestDto requestDto);

}
