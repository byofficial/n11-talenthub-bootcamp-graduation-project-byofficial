package com.n11.graduationproject.service.impl;

import com.n11.graduationproject.exception.user.UserAlreadyExistException;
import com.n11.graduationproject.model.User;
import com.n11.graduationproject.repository.IUserRepository;
import com.n11.graduationproject.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements IUserService {

    private final String CLASS_NAME_LOG = this.getClass().getSimpleName();

    private final IUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * @return Returns all users
     */
    @Override
    public List<User> findAllUsers() {
        log.info(CLASS_NAME_LOG + " service findAllUsers method is running.");

        return userRepository.findAll();
    }

    /**
     * Create a new User
     *
     * @param user type is User model
     * @return The created user is returned
     */
    @Override
    public User saveUser(User user) {
        log.info(CLASS_NAME_LOG + " service saveUser method is running.");

        String username = user.getUsername();
        boolean isUserExist = userRepository.existsByUsername(username);

        if (isUserExist) {
            log.error("User is exists! Username: " + username);
            throw new UserAlreadyExistException("Username: " + username);
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setCreatedDate(LocalDateTime.now());
        User newUser = userRepository.save(user);

        log.info(username + " is saved a new user.");
        return newUser;
    }

    /**
     * @param username is unique and type String
     * @return Returns user with unique username value
     */
    @Override
    public Optional<User> findByUsername(String username) {
        log.info(CLASS_NAME_LOG + " service findByUsername method is running.");

        return userRepository.findByUsername(username);
    }


}
