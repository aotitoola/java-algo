package org.learn.unitTesting.service;

import org.learn.unitTesting.model.User;

public class EmailVerificationServiceImpl implements EmailVerificationService {
    @Override
    public void scheduleEmailConfirmation(User user) {
        // put user details into email queue
        System.out.println("schedule email confirmation is called");
    }
}
