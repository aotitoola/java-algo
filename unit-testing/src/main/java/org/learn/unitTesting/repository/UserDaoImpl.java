package org.learn.unitTesting.repository;

import org.learn.unitTesting.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    Map<String, User> users = new HashMap<>();
    @Override
    public boolean save(User user) {
        if (!users.containsKey(user.getId())) {
            users.put(user.getId(), user);
            return true;
        }
        return false;
    }
}
