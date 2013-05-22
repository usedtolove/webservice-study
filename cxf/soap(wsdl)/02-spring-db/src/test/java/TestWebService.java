import com.mycompany.study.ws.server.entity.User;
import com.mycompany.study.ws.server.ws.WsUserService;
import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.util.Date;
import java.util.List;

/**
 * User: Hu Jing Ling
 * Date: 2013-5-22
 */
public class TestWebService {

    @Test
    public void testClient(){
        QName SERVICE_NAME = new QName("http://ws.server.ws.study.mycompany.com/", "WsUserService");
        QName PORT_NAME = new QName("http://ws.server.ws.study.mycompany.com/", "WsUserServicePort");
        String ENDPOINT_ADDRESS = "http://localhost:8080/services/userService";

        Service service = Service.create(SERVICE_NAME);
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, ENDPOINT_ADDRESS);
        WsUserService userService = service.getPort(WsUserService.class);

        User user = new User();
        user.setName("Jack");
        user.setEmail("asd@123.com");
        userService.add(user);

        List<User> userList = userService.getList();
        if(userList != null && userList.size()>0){
            for(User u : userList){
                u.setName("updated_"+u.getName());
                userService.update(u);
            }
        }

        userList = userService.getList();
        if(userList != null && userList.size()>0){
            for(User u : userList){
                userService.delete(u.getId());
            }
        }
    }

}
