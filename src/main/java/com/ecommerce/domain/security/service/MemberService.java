package com.ecommerce.domain.security.service;

import com.ecommerce.domain.security.dto.request.ChangePasswordRequest;
import com.ecommerce.domain.security.dto.response.MemberInfoResponse;
import com.ecommerce.domain.security.model.Member;
import org.springframework.security.core.userdetails.User;

public interface MemberService {
    MemberInfoResponse findById();

    Member findByEmail(String email);

    Boolean existByEmail(String email);

    void  changePassword(ChangePasswordRequest changePasswordRequest);

    Member getUserDetailsFromRefreshToken(String token) throws Exception;

    Member getUserDetailFromToken(String token) throws Exception;
}
