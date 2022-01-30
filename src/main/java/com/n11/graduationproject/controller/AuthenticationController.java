package com.n11.graduationproject.controller;

import com.n11.graduationproject.dto.request.CreateUserDto;
import com.n11.graduationproject.dto.request.LoginDto;
import com.n11.graduationproject.mapper.AuthenticationMapper;
import com.n11.graduationproject.model.User;
import com.n11.graduationproject.service.IAuthenticationService;
import com.n11.graduationproject.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")//pre-path
public class AuthenticationController {
    @Autowired
    private IAuthenticationService authenticationService;

    @Autowired
    private IUserService userService;

    @PostMapping("sign-up") //api/auth/sign-up
    public ResponseEntity<?> signUp(@RequestBody CreateUserDto userDto) {
        User user = AuthenticationMapper.INSTANCE.convertCreateUserDtoToUser(userDto);

        if (userService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(
                userService.saveUser(user),
                HttpStatus.CREATED);
    }

    @PostMapping("sign-in")//api/auth/sign-in
    public ResponseEntity<?> signIn(@RequestBody LoginDto loginDto) {
        User user = AuthenticationMapper.INSTANCE.convertLoginDtoToUser(loginDto);
        return new ResponseEntity<>(authenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
