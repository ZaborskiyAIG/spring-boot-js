package com.web.springboot.service;

import com.web.springboot.model.User;

import java.util.Set;

public interface UserService {

    void add(User user, String[] rolesId);

    Set<User> listUsers();

    void remove(Long id);

    void update(User user, String[] rolesName);

    User getUserById(Long id);

    User getUserByFirstName(String name);

    boolean checkUserById(Long id);
}
