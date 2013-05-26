package com.mycompany.webservice.server.webservice;

import com.mycompany.webservice.server.entity.User;
import com.mycompany.webservice.server.webservice.type.OperationOutputType;
import com.mycompany.webservice.server.webservice.type.UserListOutputType;
import org.springframework.stereotype.Component;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The interface exposed as soap and rest
 *
 * @ WebService is for soap
 * @ Path is for the rest top path
 *
 * @ WebMethod is for SOAP
 * @ WebParam is for SOAP parameter
 *
 * @ GET/POST/PUT/DELETE is for REST
 * @ Path is for the REST service path
 * @ PathParam is for REST parameter in url
 * @ FormParam is for REST parameter in form
 * @ Produces is marked for response type
 */

@WebService
@Path("/users")
@Produces({MediaType.APPLICATION_JSON , MediaType.APPLICATION_XML})
public interface WsUserService {

    @WebMethod
    @GET
    public UserListOutputType getList();

    @WebMethod
    @GET
    @Path("/{id}")
    public User get(@WebParam(name = "id")
                     @PathParam("id")
                     String id);

    @WebMethod
    @POST
    public void addUser(@WebParam(name = "user")User user);

    @WebMethod
    @PUT
    public void update(User user);

    @WebMethod
    @DELETE
    @Path("/{id}")
    public void delete(@WebParam(name = "id")
                            @PathParam("id")
                            String id);
}
