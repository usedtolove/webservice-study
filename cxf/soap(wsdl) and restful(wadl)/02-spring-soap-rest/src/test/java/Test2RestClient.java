import com.mycompany.webservice.server.entity.User;
import com.mycompany.webservice.server.webservice.type.UserListOutputType;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.form.Form;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//@Ignore
public class Test2RestClient {

    private final String BASE_ADDRESS = "http://localhost:8080/services/rest";

    @Test
    public void test1getList() {
        WebClient client = WebClient.create(BASE_ADDRESS);
        client.path("/users");

        UserListOutputType result =  client.get(UserListOutputType.class);
        for(User u : result.getUser()){
            System.out.println(u);
        }
    }

    @Test
    public void test2get(){
        WebClient client = WebClient.create(BASE_ADDRESS);

        String id = "ccda5a26-779d-4301-b8ad-780824c0dc4f";
        client.path("/users/"+id);
        User user = client.get(User.class);
        System.out.println(user);
    }

    @Test
    public void test3addUser(){
        WebClient client = WebClient.create(BASE_ADDRESS);
        client.path("/users");

        User user = new User();
        user.setName("User_"+System.currentTimeMillis());
        user.setEmail("Email_"+System.currentTimeMillis());
        client.post(user);
    }

    @Test
    public void test4update(){
        WebClient client = WebClient.create(BASE_ADDRESS);
        client.path("/users");

        User user = new User();
        user.setId("ccda5a26-779d-4301-b8ad-780824c0dc4f");
        user.setName("updated name");
        user.setEmail("updated email");
        client.put(user);
    }

    @Test
    public void test5delete() {
        WebClient client = WebClient.create(BASE_ADDRESS);

        String id = "ccda5a26-779d-4301-b8ad-780824c0dc4f";
        client.path("/users/"+id);
        client.delete();
    }

}

