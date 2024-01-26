package edu.dev.backend.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 附件联系表 前端控制器
 * </p>
 *
 * @author 林俊杰
 * @since 2022-03-15
 */
@RestController
@RequestMapping("/fileRef")
@CrossOrigin
@Controller
public class FileRefController {
    @GetMapping(value = "/hello")
    public Object hello(){
        return "Hello Gov A O S M Platform!";
    }

    @PostMapping(value = "postTest")
    public Object postTest(@RequestBody Map<String, String> form){
        Integer id = Integer.valueOf(form.get("id"));
        String password = form.get("password");
        return "id :"+id+", pwd:"+password+"\n other things:"+form;
    }

}

