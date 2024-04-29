package com.springboot.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.springboot.user.LoginController;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * 重复请求的拦截器
 * 
 * @Component：该注解将其注入到IOC容器中
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	/**
	 * preHandler方法，在controller方法之前执行
	 * 
	 * 判断条件仅仅是用了uri，实际开发中根据实际情况组合一个唯一识别的条件。
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		Object userSession = session.getAttribute(LoginController.userSession);
		if (userSession == null) {
			response.sendRedirect(request.getContextPath() + "/login/index");
			return false;
		}
		return true;
	}
}