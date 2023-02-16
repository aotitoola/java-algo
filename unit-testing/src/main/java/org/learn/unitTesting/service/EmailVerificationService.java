package org.learn.unitTesting.service;

import org.learn.unitTesting.model.User;

public interface EmailVerificationService {

    void scheduleEmailConfirmation(User user);
}
