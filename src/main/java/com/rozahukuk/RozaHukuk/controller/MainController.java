package com.rozahukuk.RozaHukuk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
