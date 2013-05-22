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
        userDao.update(user);
    }

    public void deleteById(String id) {
        User user = userDao.getById(id);
        userDao.deleteById(user);
    }
}
