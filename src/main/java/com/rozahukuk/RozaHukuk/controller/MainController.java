package com.rozahukuk.RozaHukuk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Controller
public class MainController {
    @RequestMapping("/")
    public ModelAndView page() {

        ModelAndView modelAndView = new ModelAndView("index");

        return modelAndView;
    }

    @RequestMapping("/single.html")
    public ModelAndView about() {

        ModelAndView modelAndView = new ModelAndView("single");

        return modelAndView;
    }
    @RequestMapping("/#home-section")
    public ModelAndView Home() {

        ModelAndView modelAndView = new ModelAndView("home-section");

        return modelAndView;
    }

    @Autowired
    public JavaMailSender javaMailSender;


    @PostMapping("/sendMail")
    public String sendMail( @RequestParam(required=false,name="name")
                                        String name, @RequestParam(required=false,name="subject")
            String subject, @RequestParam(required=false,name="mail")
            String mail, @RequestParam(required=false,name="phone")
            String phone, @RequestParam(required=false,name="text") String text)
            throws MessagingException, IOException {


        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("ibrahim.tarla@fsm.stu.edu.tr");




        helper.setSubject(subject);


        // true = text/html
        helper.setText( name + "\n" + mail + "\n" + phone + "\n" + text, false);


        javaMailSender.send(msg);


        return "index";


    }


}
