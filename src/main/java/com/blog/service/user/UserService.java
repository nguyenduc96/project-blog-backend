package com.blog.service.user;

import com.blog.model.user.User;
import com.blog.model.user.UserPrinciple;
import com.blog.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserPrinciple loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserPrinciple.build(user);
    }
}
