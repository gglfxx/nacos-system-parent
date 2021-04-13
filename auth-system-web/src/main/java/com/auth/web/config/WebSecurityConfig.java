package com.auth.web.config;

import com.auth.web.security.AuthUserDetailsService;
import com.auth.web.security.JwtAuthenticationFilter;
import com.auth.web.security.JwtAuthenticationProvider;
import com.auth.web.security.JwtLoginFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

/**
 * spring security 配置
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserDetailsService authUserDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new JwtAuthenticationProvider(authUserDetailsService));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //放行静态资源
        web.ignoring()
                .antMatchers(HttpMethod.GET,
                        //静态资源
                        "/**/*.html",
                        "/**/*.css",
                        "/**/*.js",
                        "/images/**",
                        //swagger
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**",
                        "/v2/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
        http.cors().and().csrf().disable()
                .authorizeRequests()
                // 跨域预检请求
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                //.antMatchers("/").permitAll()
                // 其他所有请求需要身份认证
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html") //登录页面 不设限访问
                .loginProcessingUrl("/login")
                .permitAll().
                 and()
                .logout().logoutUrl("/logout")
                .clearAuthentication(true)
                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).
                 //去除set 'X-Frame-Options' to 'deny'.
                 and().headers().frameOptions().disable().cacheControl();
        // 开启登录认证流程过滤器 就无法使用rememberMe 便于前后端分离
        http.addFilterBefore(new JwtLoginFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
        // 访问控制时登录状态检查过滤器
        http.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
}
