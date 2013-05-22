package com.mycompany.study.ws.server.service;

import com.mycompany.study.ws.server.dao.UserDao;
import com.mycompany.study.ws.server.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    public UserServiceImpl() {
        System.out.println("*************************UserServiceImpl ...");
        System.out.println("*************************UserServiceImpl ...");
        System.out.println("*************************UserServiceImpl ...");
        System.out.println("*************************UserServiceImpl ...");
        System.out.println("*************************UserServiceImpl ...");
    }

    @Resource
    private UserDao userDao;

    public List<User> getList() {
        return userDao.getList();
    }

    public User getById(String id) {
        return userDao.getById(id);
    }

    public void create(User user) {
        userDao.create(user);
    }

    public void update(User user){
        User u = userDao.getById(user.getId());
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        userDao.update(user);
    }

    public void deleteById(String id) {
        userDao.deleteById(id);
    }
}
