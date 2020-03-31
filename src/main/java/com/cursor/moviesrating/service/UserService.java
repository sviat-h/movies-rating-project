package com.cursor.moviesrating.service;

import com.cursor.moviesrating.entity.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User save(User user);

    User findUserByUsername(String username);

    void deleteUserByUsername(String username);
}
