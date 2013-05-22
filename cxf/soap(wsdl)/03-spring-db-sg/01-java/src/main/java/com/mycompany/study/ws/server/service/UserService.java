package com.mycompany.study.ws.server.service;


import com.mycompany.study.ws.server.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getList();

    public User getById(String id);

    public void create(User user);

    public void update(User user);

    public void deleteById(String id);

}
