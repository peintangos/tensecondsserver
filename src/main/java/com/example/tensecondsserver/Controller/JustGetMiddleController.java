package com.example.tensecondsserver.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/justgetmiddle")
public class JustGetMiddleController {
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String get(){
        return "Hello World";
    }
}
