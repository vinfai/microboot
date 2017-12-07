package sms;

import com.vinfai.SmsApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * test
 *
 * @author fangwenhui
 * @date 2017-12-07 9:59
 **/
@SpringBootTest(classes = {SmsApplication.class})
@RunWith(SpringRunner.class)

public class SmsTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }


    @Test
    public void smsSend() throws Exception {

        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/sms/api/sendSMS")
                .param("phone", "12345678901").param("content", "helloworld");
        MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();

    }
}
