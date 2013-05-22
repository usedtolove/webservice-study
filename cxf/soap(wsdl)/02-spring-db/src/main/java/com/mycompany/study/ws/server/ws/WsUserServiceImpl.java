package com.mycompany.study.ws.server.ws;

import com.mycompany.study.ws.server.entity.User;
import com.mycompany.study.ws.server.service.UserService;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.mycompany.study.ws.server.ws.WsUserService",
            serviceName = "WsUserService")
public class WsUserServiceImpl implements WsUserService{

    public UserService userService;
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<User> getList() {
        return userService.getList();
    }

    @Override
    public void add(@WebParam(name = "user") User user) {
        userService.create(user);
    }

    @Override
    public void update(@WebParam(name = "user") User user) {
        userService.update(user);
    }

    public void delete(String id) {
        userService.deleteById(id);
    }
}
