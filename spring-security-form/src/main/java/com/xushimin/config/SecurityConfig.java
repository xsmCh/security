package com.xushimin.config;

import com.xushimin.handler.MyAuthenticationFailureHandler;
import com.xushimin.handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * WebSecurityConfigurerAdapter已经废弃了，后面要改成新的配置方式
 * 1）这里只是配置了表单登录。
 * 2）关于登录的数据源，还是系统默认的。
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin() // 这里在配置表单登录
                .loginPage("/login.html") // 当需要登录的时候让框架返回重定向到登录页面的302响应
                .loginProcessingUrl("/doLogin") // 不需要应用提供表单登录的接口，由框架提供登录功能，直接配置登录的接口即可让框架匹配即可。问题：框架还提供了哪些接口功能，并且运行配置，是不是还有一个logout？
                .successHandler(new MyAuthenticationSuccessHandler()) // 自定义登录成功处理器
                .failureHandler(new MyAuthenticationFailureHandler()) // 自定义登录失败处理器
                .usernameParameter("uname") // 表单登录的参数是formData，从该参数字段获取userName
                .passwordParameter("passwd") // 表单登录的参数是formData，从该参数字段获取password
                .permitAll()
                .and()
                .csrf().disable();
    }
}
