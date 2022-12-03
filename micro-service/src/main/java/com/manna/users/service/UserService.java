package com.manna.users.service;

import com.manna.users.entities.Role;
import com.manna.users.entities.User;
public interface UserService {
User saveUser(User user);
User findUserByUsername (String username);
Role addRole(Role role);
User addRoleToUser(String username, String rolename);
}