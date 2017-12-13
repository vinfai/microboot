import com.vinfai.ShiroApplication;
import com.vinfai.dao.UserMapper;
import com.vinfai.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;
import java.util.Random;

/**
 * @author fangwenhui
 * @date 2017-12-13 19:40
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShiroApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value="dev")
@EnableTransactionManagement
public class UserTest {

    @Autowired
    private UserMapper userDao;

    @Test
    public void test() {
        User user = new User();
        user.setNickname("jack"+ new Random());
        user.setEmail("vinfai85@gmail.com");
        user.setPswd("123456");
        user.setStatus(1L);
        user.setCreateTime(new Date());
        userDao.insert(user);
    }

    @Test
    public void query() {
        String name = "jack";
        User user = userDao.selectUserByName(name);
        System.out.println(user.getId());

    }

}
