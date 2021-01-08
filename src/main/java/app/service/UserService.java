package app.service;

import app.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);
    public List<User> getAllUser();
    public void updateUser(User user);
    public void deleteUserById(Long id);
    public User getUser(Long id);
}