package com.n11.graduationproject.service.impl;


import com.n11.graduationproject.model.User;
import com.n11.graduationproject.security.UserPrincipal;
import com.n11.graduationproject.security.jwt.IJwtProvider;
import com.n11.graduationproject.service.IAuthenticationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
public class AuthenticationServiceImpl implements IAuthenticationService {

    private final String CLASS_NAME_LOG = this.getClass().getSimpleName();

    private final AuthenticationManager authenticationManager;

    private final IJwtProvider jwtProvider;


    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager, IJwtProvider jwtProvider) {
        this.authenticationManager = authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    /**
     * @param signInRequest type is User
     * @return Generates tokens for the login user
     */
    @Override
    public String signInAndReturnJWT(User signInRequest) {
        log.info(CLASS_NAME_LOG + " service signInAndReturnJWT method is running.");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(), signInRequest.getPassword())
        );

        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();

        log.info("JWT token generated!");
        return jwtProvider.generateToken(userPrincipal);
    }
}
