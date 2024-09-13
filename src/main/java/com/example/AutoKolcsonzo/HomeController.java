package com.example.AutoKolcsonzo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(path = "/")
public class HomeController {


    @RequestMapping("/home")
    public String getHomePage(){
        return "home_page";
    }


}
