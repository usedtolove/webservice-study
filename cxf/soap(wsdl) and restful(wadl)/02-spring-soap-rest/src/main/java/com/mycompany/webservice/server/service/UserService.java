package com.mycompany.webservice.server.service;

import com.mycompany.webservice.server.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getList();

    public User getById(String id);

    public void create(User user);

    public void update(User user);

    public void deleteById(String id);

}
