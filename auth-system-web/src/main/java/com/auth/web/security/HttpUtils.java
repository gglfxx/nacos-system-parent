package com.auth.web.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.auth.web.entity.Result;
import com.auth.web.util.JasonUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * HTTP工具类
 */
public class HttpUtils {

	/**
	 * 获取HttpServletRequest对象
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	/**
	 * 输出信息到浏览器
	 * @param response
	 * @param data
	 * @throws IOException
	 */
	public static void write(HttpServletResponse response, Object data) throws IOException {
		JwtAuthenticatioToken token = null;
		AuthenticationException failed = null;
		int code = 0;
		String msg = null;
		String jwtToken = null;
		//处理登陆成功后
		if(data instanceof JwtAuthenticatioToken){
			token = (JwtAuthenticatioToken) data;
			jwtToken = token.getToken();
		}else if(data instanceof AuthenticationException){
			//处理登陆失败后
			failed = (AuthenticationException) data;
			code = 1;
			msg = failed.getMessage();
		}
		response.setContentType("application/json; charset=utf-8");
        Result<String> result = new Result<>();
        result.setData(jwtToken);
        result.setMsg(msg);
        result.setCode(code);
        response.getWriter().print(JasonUtil.obj2String(result));
        response.getWriter().flush();
        response.getWriter().close();
	}
	
}
