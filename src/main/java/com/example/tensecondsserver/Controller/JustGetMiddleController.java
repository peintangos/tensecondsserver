package com.example.tensecondsserver.Controller;

import com.example.tensecondsserver.DTO.RequestMessageJustGetMiddle;
import com.example.tensecondsserver.DTO.ResponseMessageCountTime;
import com.example.tensecondsserver.DTO.ResponseMessageJustGetMiddle;
import com.example.tensecondsserver.Service.JustGetMiddleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/justgetmiddle")
public class JustGetMiddleController {
    @Autowired
    private JustGetMiddleService justGetMiddleService;
    @RequestMapping(value="/list", method= RequestMethod.POST)
    public  String makeRecord(@RequestBody RequestMessageJustGetMiddle requestMessageJustGetMiddle){
        justGetMiddleService.save(requestMessageJustGetMiddle);
        return "Hello World";
    }
    @RequestMapping(value="/list", method= RequestMethod.GET)
    public List<ResponseMessageJustGetMiddle> getList(){
        return justGetMiddleService.all();
    }
    @RequestMapping(value="/keys",method= RequestMethod.GET)
    public String getKeyword(@RequestParam String key){
        return justGetMiddleService.findByKeyword(key);
    }
}
