package com.hsenid.webapps.controller;

import com.hsenid.webapps.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hsenid on 4/5/17.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
    public ModelAndView loadLogin(){
        ModelAndView model = new ModelAndView("login");
        return model;
    }

    @RequestMapping(value = "/processlogin", method = RequestMethod.POST)
    public String validateCredentials(@ModelAttribute("user") User user, BindingResult result, final RedirectAttributes redirectAttributes, HttpServletRequest request){
        // TODO: 4/5/17 Incorporate credentials retrieval from the database
        ModelAndView model = new ModelAndView();
        model.addObject("user", user);

        String correctUname = "admin";
        String correctPassword = "pass";
        boolean validUser = false;
        boolean success = false;
        String destination = "redirect:/login.htm";
        if(user.getUsername().equals(correctUname) && user.getPassword().equals(correctPassword)){
            success = true;
            validUser = true;
            destination = "redirect:/home.htm";
        }

        else{
            redirectAttributes.addFlashAttribute("error", "Invalid Credentials!");
        }

        redirectAttributes.addFlashAttribute("validUser", validUser);
        redirectAttributes.addFlashAttribute("success", success);
        return destination;
    }
}
