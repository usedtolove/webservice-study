package com.mycompany.study.ws.server.ws;

import com.mycompany.study.ws.server.entity.User;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface WsUserService {

    public List<User> getList();

    public void add(@WebParam(name = "user") User user);

    public void update(@WebParam(name = "user") User user);

    public void delete(@WebParam(name = "id") String id);
}
