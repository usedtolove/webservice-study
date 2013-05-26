package com.mycompany.webservice.server.webservice;

import com.mycompany.webservice.server.entity.User;
import com.mycompany.webservice.server.service.UserService;
import com.mycompany.webservice.server.webservice.type.UserListOutputType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.List;

@WebService(endpointInterface = "com.mycompany.webservice.server.webservice.WsUserService",
           serviceName = "WsUserService")
public class WsUserServiceImpl implements WsUserService {

    @Resource
    public UserService userService;

    public UserListOutputType getList() {
        UserListOutputType userListOutputType = new UserListOutputType();
        userListOutputType.getUser().addAll(userService.getList());
        return userListOutputType;
    }

    public User get(String id) {
        return userService.getById(id);
    }


    public void addUser(User user) {
        userService.create(user);
    }

    public void update(User user) {
        User u = userService.getById(user.getId());
        if (u != null) {
            u.setName(user.getName());
            u.setEmail(user.getEmail());
            userService.update(u);
        }
    }

    public void delete(String id) {
        User user = userService.getById(id);
        Response r;
        if (user != null) {
            userService.deleteById(id);
        }
    }
}
