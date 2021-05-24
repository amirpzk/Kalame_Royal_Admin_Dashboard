package com.Prana.KalameRoyal.Authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/packages/create-package").hasAuthority("admin")
        .and().csrf();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/authentication/login")
        .antMatchers("/packages/create-package")
        .antMatchers("/packages/get-all")
        .antMatchers("/packages/get-package-by-id}")
        .antMatchers("/packages/hidden-word")
        .antMatchers("/packages/edit-word")
        .antMatchers("/packages/change-package-final-state")
        .antMatchers("/packages/get-all-words")
        .antMatchers("/packages/update-package")
        .antMatchers("/categories");
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("admin").roles(ADMIN.toString())
//                .and()
//                .withUser("guest").password("guest").roles(GUEST.toString());
//    }

}
