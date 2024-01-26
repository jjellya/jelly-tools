package edu.dev.backend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Create By  @林俊杰
 * 2022/3/15 22:47
 *
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
@Controller
public class HelloController {

    @GetMapping(value = "/hello")
    public Object hello(){
        return "Hello, I am jelly!";
    }

    @PostMapping(value = "postTest")
    public Object postTest(@RequestBody Map<String, String> form){
        Integer id = Integer.valueOf(form.get("id"));
        String password = form.get("password");
        return "id :"+id+", pwd:"+password+"\n other things:"+form;
    }
}
