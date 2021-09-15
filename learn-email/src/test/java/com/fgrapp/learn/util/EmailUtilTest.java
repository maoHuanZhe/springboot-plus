package com.fgrapp.learn.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class EmailUtilTest {

    @Autowired
    private EmailUtil emailUtil;

    @Test
    public void testSendSimpleMail(){
        emailUtil.sendSimpleMail();
    }
    @Test
    public void sendThymeleafMail(){
        emailUtil.sendThymeleafMail();
    }
    @Test
    public void sendImgResMail(){
        emailUtil.sendImgResMail();
    }
    @Test
    public void sendAttachFileMail(){
        emailUtil.sendAttachFileMail();
    }
}
