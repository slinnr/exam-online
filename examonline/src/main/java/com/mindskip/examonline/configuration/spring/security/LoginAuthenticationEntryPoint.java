package com.mindskip.examonline.configuration.spring.security;

import com.mindskip.examonline.base.SystemCode;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 未登录
 * @author  孙林
 */
@Component
public final class LoginAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

    /*
     *
     * @Description 配置登录请求的url
     * @Date 2021/1/9 下午11:21
     * @return
     */
    public LoginAuthenticationEntryPoint() {
        super("/api/user/login");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        RestUtil.response(response, SystemCode.UNAUTHORIZED);
    }

}
