package com.mycompany.study.ws.server.dao;

import com.mycompany.study.ws.server.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Resource
    private SessionFactory sessionFactory;

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    public List<User> getList() {
        return getSession().createCriteria(User.class).list();
    }

    public void create(User user) {
        getSession().save(user);
    }

    public void update(User user) {
        getSession().saveOrUpdate(user);
    }

    public User getById(String id) {
        return (User) getSession().get(User.class, id);
    }

    public void deleteById(User user) {
        getSession().delete(user);
    }

}
