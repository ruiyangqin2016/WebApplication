package psu.edu.bookstore.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {

    @GetMapping(value = "/about-us")
    public String aboutUs(){
        return "aboutus";
    }

    @GetMapping(value = "/contact-us")
    public String contactUs(){
        return "contactus";
    }

//    @GetMapping(value = "/bookstore/view")
//    public String view(){return "view";}
}
