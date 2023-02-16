package org.learn.unitTesting.repository;


import org.learn.unitTesting.model.User;

public interface UserDao {

    boolean save(User user);
}
