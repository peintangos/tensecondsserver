package com.example.tensecondsserver.Controller;

import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.http.HttpRequest;

@RestController
@RequestMapping("/counttime")
public class CountTimeController {
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public String get(){
        return "Hello World";
    }
}
