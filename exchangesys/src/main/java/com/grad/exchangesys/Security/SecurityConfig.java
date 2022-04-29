package com.grad.exchangesys.Security;

import com.grad.exchangesys.Filter.CustomAuthenticationFilter;
import com.grad.exchangesys.Filter.CustomAuthorizationFilter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration @EnableWebSecurity @RequiredArgsConstructor
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       super.configure(auth);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/api/login");
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.authorizeRequests().antMatchers( HttpMethod.POST,

                "/api/register"
                ).permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.GET,
                "/",
                "/api/token/refresh/**",
                "/css/**",
                "/images/**",
                "/scss/**",
                "/js/**").permitAll();

//        http.authorizeRequests().antMatchers( HttpMethod.GET,
//                "/api/**"
//
//        ).hasAnyAuthority("ROLE_USER");
//
//        http.authorizeRequests().antMatchers(
//                "/api/**"
//
//        ).hasAnyAuthority("ROLE_ADMIN");

        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/api/signup").permitAll();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);





    }





}
