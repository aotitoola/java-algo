package org.learn.unitTesting.service;

import org.learn.unitTesting.model.User;
import org.learn.unitTesting.repository.UserDao;


import java.util.UUID;

public class UserServiceImpl implements UserService {

    UserDao userDao;

    EmailVerificationService emailVerificationService;

    public UserServiceImpl(UserDao userDao, EmailVerificationService emailVerificationService) {
        this.emailVerificationService = emailVerificationService;
        this.userDao = userDao;
    }

    @Override
    public User createUser(
            String firstName,
            String lastName,
            String email,
            String password, String repeatPassword) {

        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("User's first name is empty.");
        }

        User user = new User(UUID.randomUUID().toString(), firstName, lastName, email);
        boolean isUserCreated;

        // boolean isUserCreated = userDao.save(user);

        try {
            isUserCreated = userDao.save(user);
        } catch (RuntimeException ex) {
            throw new UserServiceException(ex.getMessage());
        }

        if (!isUserCreated) {
            throw new UserServiceException("could not create user");
        }

        try {
            emailVerificationService.scheduleEmailConfirmation(user);
        } catch (RuntimeException ex) {
            throw new UserServiceException(ex.getMessage());
        }

        return user;
    }
}
