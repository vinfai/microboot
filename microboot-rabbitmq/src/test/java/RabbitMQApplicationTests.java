import com.vinfai.RabbitMQApplication;
import com.vinfai.topic.UserInfoSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * test
 *
 * @author fangwenhui
 * @date 2017-12-04 14:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RabbitMQApplication.class)
//@ActiveProfiles("test")
public class RabbitMQApplicationTests {

   /* @Autowired@Qualifier("helloSender")
    private HelloSender helloSender;

    @Test
    public void hello() throws InterruptedException {
        for(int i=0;i<100;i++) {
            helloSender.send();
        }
        Thread.sleep(10000L);
    }*/

    @Autowired
    private UserInfoSender userInfoSender;

    @Test
    public void UserInfoSender() throws InterruptedException {
//        userInfoSender.sendUserInfo();
        userInfoSender.sendUserPoint();
        Thread.sleep(100000L);
    }

}
