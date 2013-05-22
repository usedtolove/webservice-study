
import com.mycompany.study.ws.server.entity.User;
import com.mycompany.study.ws.server.service.UserService;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestUser extends AbstractJUnit4SpringContextTests {

    @Resource
    private UserService userService;

    @Test
    public void save(){
        DataFactory df = new DataFactory();
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setName(df.getName());
            user.setEmail(df.getEmailAddress());
            userService.create(user);
        }
    }

}
