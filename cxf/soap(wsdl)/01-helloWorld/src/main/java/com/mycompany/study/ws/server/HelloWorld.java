package com.mycompany.study.ws.server;

import com.mycompany.study.ws.server.vo.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface HelloWorld {
    String sayHi(@WebParam(name = "name") String name);

    String sayHiToUser(@WebParam(name = "user") User user);

    User getUser(@WebParam(name = "name")
                 String name);

    List<Integer> getSimpleList(@WebParam(name = "num") Integer num);

    List<User> getComplexList();
}
