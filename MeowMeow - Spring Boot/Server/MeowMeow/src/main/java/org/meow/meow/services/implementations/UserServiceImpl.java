package org.meow.meow.services.implementations;

import org.meow.meow.entities.User;
import org.meow.meow.repos.UserRepository;
import org.meow.meow.services.interfaces.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository repository;

    public UserServiceImpl() {
        this.repository = new UserRepository();
    }

    @Override
    public void login(User user) {
       // TODO
    }

    @Override
    public void register() {

    }

    @Override
    public void logout() {

    }
}