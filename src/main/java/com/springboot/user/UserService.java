package com.springboot.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.springboot.user.pojo.User;

@Service
public class UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User checkLogin(String username) {
        logger.debug("checkLogin:username=[{}]", username);
        if (username != null && "test".equals(username)) {
            User user = new User();
            user.setUsername("test");
            user.setPassword("123456");
            return user;
        }
        return null;
    }

}
