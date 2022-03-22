package com.acc.demo.security;

import com.acc.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class config extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserInfoService userInfoService;
//    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //auth.userDetailsService(userInfoService);

        auth.inMemoryAuthentication()
                .withUser("rakesh")
                .password("$2a$12$2exEyipw64yzAfdEgWY3meSSxB2NV5S/T0YpPL3qhwoaXD4oc74MW")
                .roles("ADMIN")
                .and()
                .withUser("abc")
                .password("$2a$12$ztMAchEbgfVIChOOxV04G.6Le55BQBtoxS4CLLDdMytbOelrQDrYu")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPassEncoded(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasRole("USER")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();

    }
}
