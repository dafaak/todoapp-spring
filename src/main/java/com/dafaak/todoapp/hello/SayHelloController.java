package com.dafaak.todoapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    // say-hello => Hello !
    @RequestMapping("say-hello")
    @ResponseBody
    public String sayHello() {
        return "Hello!!";
    }
}
