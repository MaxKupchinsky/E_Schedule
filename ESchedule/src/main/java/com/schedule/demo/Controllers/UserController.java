package com.schedule.demo.Controllers;

import com.schedule.demo.Services.UserDetailsServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserDetailsServiceUtil userDetailsServiceUtil;

    @GetMapping
    public ModelAndView getRegistrationForm(){
        return new ModelAndView("reg");
    }

    @PostMapping("/reg")
    public String post(@RequestParam Map<String, String> params) {
        System.out.println(params.get("username"));
        System.out.println(params.get("password"));
        return userDetailsServiceUtil.regAcc(params.get("username"), params.get("password"));
    }
}
