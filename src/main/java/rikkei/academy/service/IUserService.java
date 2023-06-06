package rikkei.academy.service;

import rikkei.academy.model.User;

public interface IUserService {
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    void save(User user);

}
