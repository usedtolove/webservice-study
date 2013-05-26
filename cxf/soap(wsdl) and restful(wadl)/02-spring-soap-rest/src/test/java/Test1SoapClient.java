import com.mycompany.webservice.server.entity.User;
import com.mycompany.webservice.server.webservice.WsUserService;
import com.mycompany.webservice.server.webservice.type.UserListOutputType;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

//@Ignore
public class Test1SoapClient {

    private WsUserService client; // web service client

    @Before
    public void before() throws Exception{
        QName SERVICE_NAME = new QName("http://webservice.server.webservice.mycompany.com/", "WsUserService");
        QName PORT_NAME = new QName("http://webservice.server.webservice.mycompany.com/", "WsUserServicePort");
        String ENDPOINT_ADDRESS = "http://localhost:8080/services/user";

        Service service = Service.create(SERVICE_NAME);
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, ENDPOINT_ADDRESS);
        client = service.getPort(WsUserService.class);
    }

    @Test
    public void test1getList(){
//        List<User> list = client.getList();
//        for(User u : list){
//            System.out.println(u);
//        }
    }

    @Test
    public void test2addUser() {
        User user = new User();
        user.setName("Jack");
        user.setEmail("jack@123.com");
        client.addUser(user);
    }

    @Test
    public void test3update(){
//        User user = new User();
//        user.setId("1774fe26-f9a1-4d3a-b544-5fa790ff887b");
//        user.setName("updated name");
//        user.setEmail("updated email");
//        client.update(user);
    }

    @Test
    public void test4delete(){
//        String id = "1774fe26-f9a1-4d3a-b544-5fa790ff887b";
//        client.delete(id);
    }

}
