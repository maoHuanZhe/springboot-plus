package com.fgrapp.learn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.FileUrlResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.Date;

/**
 * EmailUtil
 *
 * @author fan guang rui
 * @date 2021年09月14日 20:22
 */
@Component
public class EmailUtil {
    @Autowired
    JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sendEmail;
    @Autowired
    private TemplateEngine templateEngine;
    /**
     * 普通邮件发送
     */
    public void sendSimpleMail() {
        // 构建一个邮件对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 设置邮件主题
        message.setSubject("这是一封测试邮件");
        // 设置邮件发送者，这个跟application.yml中设置的要一致
        message.setFrom(sendEmail);
        // 设置邮件接收者，可以有多个接收者，中间用逗号隔开，以下类似
        // message.setTo("10*****16@qq.com","12****32*qq.com");
        message.setTo("mail_fanguangrui@163.com");
        // 设置邮件抄送人，可以有多个抄送人
        message.setCc("898365387@qq.com");
        // 设置隐秘抄送人，可以有多个
        message.setBcc("1320072891@qq.com");
        // 设置邮件发送日期
        message.setSentDate(new Date());
        // 设置邮件的正文
        message.setText("这是测试邮件的正文");
        // 发送邮件
        javaMailSender.send(message);
    }
    /**
     * 发送带附件的邮件
     */
    public void sendAttachFileMail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            // true表示构建一个可以带附件的邮件对象
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

            helper.setSubject("这是一封测试邮件");
            helper.setFrom(sendEmail);
            helper.setTo("mail_fanguangrui@163.com");
            helper.setSentDate(new Date());
            helper.setText("这是测试邮件的正文");
            // 第一个参数是自定义的名称，后缀需要加上，第二个参数是文件的位置
            helper.addAttachment("bg1.png",new File("E:\\project\\server\\AJ-Captcha-Images\\jigsaw\\bg1.png"));
            javaMailSender.send(mimeMessage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 正文中带图片的邮件
     */
    public void sendImgResMail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setSubject("这是一封测试邮件");
            helper.setFrom(sendEmail);
            helper.setTo("898365387@qq.com");
            helper.setSentDate(new Date());
            // src='cid:p01' 占位符写法 ，第二个参数true表示这是一个html文本
            helper.setText("<p>hello 大家好，这是一封测试邮件，这封邮件包含两种图片，分别如下</p><p>第一张图片：</p><img src='cid:p01'/><p>第二张图片：</p><img src='cid:p02'/>",true);
            // 第一个参数指的是html中占位符的名字，第二个参数就是文件的位置
            helper.addInline("p01",new FileSystemResource(new File("E:\\project\\server\\AJ-Captcha-Images\\jigsaw\\bg1.png")));
            helper.addInline("p02",new FileSystemResource(new File("E:\\project\\server\\AJ-Captcha-Images\\jigsaw\\bg2.png")));javaMailSender.send(mimeMessage);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 发送模板邮件
     * @return
     */
    public boolean sendThymeleafMail() {
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            mimeMessage.setSubject("【FGRAPP】注册登录验证码");
            helper.setFrom(sendEmail);
            helper.setTo("898365387@qq.com");
            helper.setSentDate(new Date());
            // 这里引入的是Template的Context
            Context context = new Context();
            // 设置模板中的变量
            context.setVariable("code", "123456");
            // 第一个参数为模板的名称
            String process = templateEngine.process("register.html", context);
            // 第二个参数true表示这是一个html文本
            helper.setText(process,true);
            javaMailSender.send(mimeMessage);
            return true;
        }  catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
