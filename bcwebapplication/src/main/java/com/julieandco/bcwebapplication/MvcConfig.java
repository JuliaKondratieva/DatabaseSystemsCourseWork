package com.julieandco.bcwebapplication;
import com.julieandco.bcwebapplication.entities.Book;
import com.julieandco.bcwebapplication.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Configuration
@RestController
public class MvcConfig {

    @Autowired
    BookService bookService;

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
        System.out.println(request.getRemoteUser().toString());
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
    public ModelAndView admin(HttpServletRequest request)
    {
        if (request.isUserInRole("USER")) {
            System.out.println("DENIED");
            throw new AccessDeniedException("");

        }
        return new ModelAndView("adminpage");
    }

    @RequestMapping("/catalogue")
    public ModelAndView viewHomePage(Model model) {
        List<Book> listBooks = bookService.getAllBooks();
        model.addAttribute("listBooks", listBooks);

        return new ModelAndView("temp");
    }
}
