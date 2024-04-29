package com.springboot.user;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.user.pojo.User;
import com.springboot.utils.ResultUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping(value ="login")
@Controller
public class LoginController {
    public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    public static final String userSession = "user";
    public static final String userverifSession = "userverif";

    @Autowired
    private UserService userService;

    @RequestMapping(value ="index")
    public String indexLogin(Model model, HttpSession session) {
        return "login/login";
    }

    @RequestMapping(value ="login")
    @ResponseBody
    public Map<String, Object> login(String username, String password, String verif, HttpServletRequest request, HttpSession session) {
        session.setAttribute(userverifSession, null);
        if (!StringUtils.hasText(username) || !StringUtils.hasText(password)) {
            return ResultUtils.setResult(true, -1, "账号或密码为空", "-2:验证码错误|-1:密码或账号错误|1:登陆成功|2:登陆成功,缓存登陆|0:密码或账号错误");
        }
        Map<String, Object> map = ResultUtils.createMap();
        User checkLogin = this.userService.checkLogin(username);
        //demo 去除加密 if (checkLogin != null && checkLogin.getPassword().equals(createMd5Password(password))) {
        if (checkLogin != null && checkLogin.getPassword().equals(password)) {
            session.setAttribute(userSession, checkLogin);
            map.put(userSession, checkLogin.getUsername());
            return ResultUtils.setResult(true, 1, "登陆成功", map);
        }
        return ResultUtils.setResult(true, 0, "密码或账号错误");
    }
}