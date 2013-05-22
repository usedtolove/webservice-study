package com.mycompany.study.ws.server.webservice;

import com.mycompany.study.ws.server.entity.User;
import com.mycompany.study.ws.server.service.UserService;
import com.mycompany.study.ws.server.utils.MailUtils;
import com.mycompany.study.ws.server.webservice.type.OperationOutputType;
import com.mycompany.study.ws.server.webservice.type.UserListOutputType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.study.ws.server.webservice.WsUserService",
            serviceName = "WsUserService")
public class WsUserServiceImpl implements WsUserService{

    public UserService userService;
    public void setUserService(UserService userService) {
        System.out.println("********** setUserService");
        System.out.println("********** setUserService");
        System.out.println("********** setUserService");
        System.out.println("********** setUserService");
        System.out.println("********** setUserService");
        this.userService = userService;
    }

    public UserListOutputType getList() {
        UserListOutputType userListOutputType = new UserListOutputType();
        userListOutputType.getUser().addAll(userService.getList());
        return userListOutputType;
    }

    public OperationOutputType create(String name, String email) {
        if(MailUtils.isNotValidEmail(email)){
            return new OperationOutputType("false" , "is a unavailable email!");
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userService.create(user);
        return new OperationOutputType("true" , "record created");
    }

    public OperationOutputType update(String id, String name, String email){
        if(MailUtils.isNotValidEmail(email)){
            return new OperationOutputType("false" , "is a unavailable email!");
        }
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        userService.update(user);
        return new OperationOutputType("true" , "record updated");
    }

    public OperationOutputType delete(String id) {
        userService.deleteById(id);
        return new OperationOutputType("true" , "record deleted");
    }
}
