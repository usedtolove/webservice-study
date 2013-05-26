import com.mycompany.webservice.server.entity.User;
import com.mycompany.webservice.server.service.UserService;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class InitData extends AbstractJUnit4SpringContextTests {

    @Resource
    private UserService userService;

    @Test
    public void save(){
        DataFactory df = new DataFactory();

        for (int i = 0; i < 40; i++) {
            User user = new User();
            user.setName(df.getName());
            user.setEmail(df.getEmailAddress());
            userService.create(user);
        }
    }

}
