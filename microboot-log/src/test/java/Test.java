import com.vinfai.LogApplication;
import com.vinfai.util.LogFileName;
import com.vinfai.util.LogUtil;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author fangwenhui
 * @date 2017-12-14 19:43
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {LogApplication.class})
@ActiveProfiles(value = "dev")
public class Test {

    /**
     * logstash tcp 格式化后的数据
     * logger_name ： Logger 创建时候的名字
     *
     {
     "@timestamp" => 2017-12-15T01:50:32.232Z,
     "level" => "ERROR",
     "port" => 56701,
     "thread_name" => "main",
     "level_value" => 40000,
     "@version" => 1,
     "host" => "10.1.16.67",
     "logger_name" => "hahahName",
     "message" => "hello1878"
     }
     */
   /* private Logger logger = LoggerFactory.getLogger("hahahName");

    @org.junit.Test
    public void testLog() {
        for (int i = 0; i < 10000; i++) {
            logger.error("hello" + i);
            logger.info("info log" + i);
            logger.warn("warn log" + i);
            logger.debug("debug log" + i);
        }
    }*/


    @org.junit.Test
    public void testFile() {

        Logger logger = LogUtil.getLogger(LogFileName.USER_VISTOR);
        for (int i = 0; i < 1000; i++) {
            logger.info("hello world");
        }
    }

}
