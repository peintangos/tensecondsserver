package com.example.tensecondsserver.Controller;

import com.example.tensecondsserver.DTO.RequestMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageCountTime;
import com.example.tensecondsserver.Service.CountTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/countTime")
public class CountTimeController {
    @Autowired
    private CountTimeService countTimeService;

    @RequestMapping(value="/list", method= RequestMethod.POST)
    public String makeRecord(@RequestBody RequestMessageCountTime requestMessageCountTime){
        countTimeService.save(requestMessageCountTime);
        return "Hello World";
    }
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<ResponseMessageCountTime> getList(){
        return countTimeService.all();
    }
    @RequestMapping(value="/keys", method= RequestMethod.GET)
    public String getListByKeyWord(@RequestParam String key){
        return countTimeService.getByKeyword(key);
    }
}
