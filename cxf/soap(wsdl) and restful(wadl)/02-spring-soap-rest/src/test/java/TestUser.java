import com.mycompany.webservice.server.entity.User;
import com.mycompany.webservice.server.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.annotation.Resource;
import java.util.List;

@ContextConfiguration(value = {"classpath:application-config.xml"})
public class TestUser extends AbstractTransactionalJUnit4SpringContextTests {

    @Resource
    private UserService userService;

    @Test
    @Rollback(value = false)
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
