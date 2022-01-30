package com.n11.graduationproject.service;

import com.n11.graduationproject.model.User;

public interface IAuthenticationService {
    String signInAndReturnJWT(User signInRequest);
}
