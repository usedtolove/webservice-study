import com.mycompany.study.ws.server.HelloWorld;
import com.mycompany.study.ws.server.HelloWorldImpl;
import com.mycompany.study.ws.server.vo.User;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;
import java.util.List;

/**
 * User: Hu Jing Ling
 * Date: 2013-5-22
 */
public class TestWebService {

    @Test
    public void testClient(){
        QName SERVICE_NAME = new QName("http://server.ws.study.mycompany.com/", "HelloWorld");
        QName PORT_NAME = new QName("http://server.ws.study.mycompany.com/", "HelloWorldPort");
        String ENDPOINT_ADDRESS = "http://localhost:8080/services/HelloWorld";

        Service service = Service.create(SERVICE_NAME);
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, ENDPOINT_ADDRESS);
        HelloWorld hw = service.getPort(HelloWorld.class);
        System.out.println(hw.sayHi("World"));

        User user = hw.getUser("jack");
        System.out.println(user);

        List<Integer> list = hw.getSimpleList(5);
        System.out.println(list);

        List<User> users = hw.getComplexList();
        System.out.println(users);
    }

}
