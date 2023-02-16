package org.learn.unitTesting.service;

import org.learn.unitTesting.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String password, String repeatPassword);

}
