package com.blog.service.user;

import com.blog.model.user.User;
import com.blog.service.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface IUserService extends IBaseService<User>, UserDetailsService {
    Optional<User> findByUsername(String username);
}
