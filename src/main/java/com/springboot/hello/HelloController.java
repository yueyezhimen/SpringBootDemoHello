package com.springboot.hello;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.user.pojo.User;
import com.springboot.utils.ResultUtils;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping(value ="hello")
@Controller
public class HelloController {
    @RequestMapping(value ="helloworld")
    @ResponseBody
    public Map<String, Object> updateSampleById(User user, HttpServletRequest request) {
        return ResultUtils.setResult(true, 1, "HelloWorld");
    }
}