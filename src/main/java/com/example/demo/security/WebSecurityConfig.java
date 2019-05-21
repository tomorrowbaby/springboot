package com.example.demo.security;

import com.example.demo.serviceimpl.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * 描述：Security 配置类
 * @author wangyu
 * @date 2019/5/19
 */

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CustomUserService customUserService() {
        return new CustomUserService() ;
    }

    @Autowired
    public UserDetailsService userDetailsService ;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //路由策略和访问权限的简单配置
        http
                .authorizeRequests()
                .antMatchers("/actuator/health")
                .access("hasAnyAuthority('USER')")
                .antMatchers("/actuator/**").permitAll()
                .and()
                .formLogin()  //启用默认登录页面
                .failureForwardUrl("/login")  //登录失败返回url
                .defaultSuccessUrl("/User/test")  //登录成功跳转
                .permitAll() ;  //登录页面全部可以访问
        super.configure(http);
    }

    /**
     * 描述：配置内存用户
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       System.out.println(customUserService().loadUserByUsername("唐伯虎").getAuthorities());
        auth
              .userDetailsService((UserDetailsService) customUserService()) ;
        //      .inMemoryAuthentication()
        //      .withUser("唐伯虎").password("123456").roles("USER") ;
        //      .and()
        //      .withUser("秋香").password("123456").roles("USER");
    }

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
