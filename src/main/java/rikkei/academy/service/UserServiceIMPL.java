package rikkei.academy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.User;
import rikkei.academy.repository.IUserRepository;

@Service
public class UserServiceIMPL implements IUserService{
    @Autowired
    private IUserRepository userRepository;
    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
