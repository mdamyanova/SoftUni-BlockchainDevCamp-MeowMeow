package org.meow.meow.repos;

import org.meow.meow.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public User byUsername(String username) {
        return this
                .all()
                .stream()
                .filter(x -> x.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<User> all() {
        return this.users;
    }

    public void add(User user) {
        this.users.add(user);
    }

    public boolean userExists(String username) {
        return this.byUsername(username) != null;
    }

    public boolean isValidCredentials(String username, String password) {
        return this.userExists(username) &&
                this.byUsername(username).getPassword().equals(password);
    }
}