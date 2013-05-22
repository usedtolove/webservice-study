import com.mycompany.study.ws.server.entity.User;
import com.mycompany.study.ws.server.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestUser extends AbstractJUnit4SpringContextTests {

    @Resource
    private UserService userService;

    @Test
    public void save(){
        User user = new User();
        user.setName("jack2");
        user.setEmail("jack@163.com");
        userService.create(user);
    }

    @Test
    public void getList(){
        List list = userService.getList();
        Assert.assertTrue(list.size()>0);
    }

}
