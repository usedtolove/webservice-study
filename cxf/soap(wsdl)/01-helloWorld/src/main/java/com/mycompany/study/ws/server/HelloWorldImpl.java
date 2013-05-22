package com.mycompany.study.ws.server;

import com.mycompany.study.ws.server.vo.Pet;
import com.mycompany.study.ws.server.vo.User;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebService(endpointInterface = "com.mycompany.study.ws.server.HelloWorld",
            serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String name) {
        System.out.println("sayHi called");
        return "Hello " + name;
    }

    public User getUser(String name) {
        System.out.println("getUser called");
        User user = new User(name , new Date(), 175 , true);
        user.setPet(new Pet("旺财" , 2 ));
        return user;
    }

    public List<Integer> getSimpleList(Integer num) {
        System.out.println("getSimpleList called");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
              list.add(i);
        }
        return list;
    }

    public List<User> getComplexList() {
        System.out.println("getComplexList called");
        List<User> list = new ArrayList<User>();
        list.add(new User("AA" , new Date(), 170, true));
        list.add(new User("BB" , new Date(), 171, false));
        list.add(new User("CC" , new Date(), 172, true));
        list.add(new User("DD", new Date(), 173, false));
        return list;
    }
}
