package org.meow.meow.services.interfaces;

import org.meow.meow.entities.User;

public interface UserService {
    void login(User user);
    void register();
    void logout();
}