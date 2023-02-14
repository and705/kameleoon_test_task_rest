package com.nd705.kameleoon_test_task.service;

import com.nd705.kameleoon_test_task.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    public List<User> getAllUsers();

}
