package com.johnpank.prospring4.chapter12.config;


import com.johnpank.prospring4.chapter12.security.AuthProviderImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.naming.AuthenticationException;

@Configuration
@EnableWebSecurity
@ComponentScan("com.johnpank.prospring4.chapter12")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private static Logger logger = LoggerFactory.getLogger(SecurityConfig.class);

    @Autowired
    private AuthProviderImpl authProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider);
        //logger.debug("authentication provider is set");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers( "/login").anonymous()
                .antMatchers("/disp/**", "/monter/**", "/admin/**").authenticated()
                .and().csrf().disable()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/check")
                .usernameParameter("name")  //поле которое используется как имя пользователя
                .and().logout() //добавить возможность выхода
                .logoutUrl("/perform_logout") //ссылка для выхода (<a href="/webAppByJohn/perform_logout">Logout</a>)
                .logoutSuccessUrl("/") //куда перейти при выходе ("/"  на стартовою страницу)
                .permitAll();

    }
}


/*
 The deleteCookies method is simple as well:

    .logout()
    .logoutUrl("/perform_logout")
    .invalidateHttpSession(true)
    .deleteCookies("JSESSIONID")


*/