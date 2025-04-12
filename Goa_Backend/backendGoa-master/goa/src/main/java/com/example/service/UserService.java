package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(PasswordEncoder passwordEncoder, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    // Password encoding
    public String encodePassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // User registration
    @Transactional
    public void registerUser(User user, String confirmPassword) {
        logger.info("Registering user: {}", user.getEmail());

        if (user.getPlainPassword() == null || confirmPassword == null) {
            throw new IllegalArgumentException("Password fields cannot be null");
        }

        if (!user.getPlainPassword().equals(confirmPassword)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        // Check if the email already exists
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email already registered: " + user.getEmail());
        }

        // Encode password
        String encodedPassword = passwordEncoder.encode(user.getPlainPassword());
        user.setPasswordHash(encodedPassword);
        user.setPlainPassword(null); // Clear plain password for security

        try {
            userRepository.save(user);
            logger.info("User registered successfully: {}", user.getEmail());
        } catch (Exception e) {
            logger.error("Error occurred during user registration: ", e);
            throw new RuntimeException("Registration failed, please try again.");
        }
    }

    // User login authentication
    public String login(String email, String plainPassword) {
        logger.info("Logging in user: {}", email);

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }

        if (!passwordEncoder.matches(plainPassword, user.getPasswordHash())) {
            throw new BadCredentialsException("Invalid password for user: " + email);
        }

        logger.info("Login successful for user: {}", email);
        return "Login successful for user: " + email;
    }
}

