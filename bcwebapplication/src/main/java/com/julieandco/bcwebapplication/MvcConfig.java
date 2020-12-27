package com.julieandco.bcwebapplication;
import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.entities.OrderEntity;
import com.julieandco.bcwebapplication.service.BookService;
import com.julieandco.bcwebapplication.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    /*@Autowired
    BookService bookService;
    @Autowired
    CustomerService customerService;
    @Autowired
    AuthenticationManagerBuilder authenticationMgr;

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
    public ModelAndView defaultAfterLogin(HttpServletRequest request) throws Exception {
        System.out.println(request.getRemoteUser().toString());
        System.out.println(customerService.findByUsername(request.getRemoteUser()).getRoles());
        if (request.getRemoteUser().equals("your_admin")){
            System.out.println("REMOTEUSERADMIN");
            System.out.println("ROLE ADMIN: "+request.isUserInRole("ADMIN"));
            System.out.println("ROLE_ADMIN: "+request.isUserInRole("ROLE_ADMIN"));
            return new ModelAndView("adminpage");
        }
        return new ModelAndView("mainuserpage");
    }

    @RequestMapping(value="/ordersubmit")
    public ModelAndView submitorder() {
        return new ModelAndView("ordersubmit");
    }*/

    /*@RequestMapping(value="/adminpage")
    public ModelAndView admin(HttpServletRequest request)
    {
        if (request.isUserInRole("USER")) {
            System.out.println("DENIED");
            throw new AccessDeniedException("");

        }
        return new ModelAndView("adminpage");
    }*/

    /*@RequestMapping("/catalogue")
    public ModelAndView viewHomePage(Model model) {
        List<Book> listBooks = bookService.getAllBooks();
        model.addAttribute("listBooks", listBooks);

        return new ModelAndView("temp");
    }*/
}
