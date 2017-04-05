package com.hsenid.webapps.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by hsenid on 4/5/17.
 */
@Controller
@RequestMapping(value = "/home")
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld(){
        ModelAndView model = new ModelAndView("home");
        return model;
    }
}
