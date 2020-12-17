package com.julieandco.bcwebapplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Configuration
@RestController
public class MvcConfig {
    @RequestMapping(value="/welcome")
    public ModelAndView welcomepage() {
        return new ModelAndView("welcome");
    }

    @RequestMapping(value="/waitinglist")
    public ModelAndView listmessage() {
        return new ModelAndView("waitinglist");
    }

    @RequestMapping(value="/")
    public ModelAndView welcome() {
        return new ModelAndView("welcome");
    }
    @RequestMapping(value="/hello")
    public ModelAndView hello() {
        return new ModelAndView("hello");
    }

    @RequestMapping(value="/login")
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @RequestMapping("/homepage")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) {
        if (request.getRemoteUser().equals("your_admin")){
            System.out.println("REMOTEUSERADMIN");
            return new ModelAndView("adminpage");
        }
        return new ModelAndView("mainuserpage");
    }

    @RequestMapping(value="/ordersubmit")
    public ModelAndView submitorder() {
        return new ModelAndView("ordersubmit");
    }

    @RequestMapping(value="/adminpage")
    public ModelAndView admin() {
        return new ModelAndView("adminpage");
    }
}
