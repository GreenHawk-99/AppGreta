package com.cda.contenu_seance.configurations;

import org.springframework.context.annotation.Configuration;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/register","/**").permitAll()
                .antMatchers("/gestionnaire/**").hasAnyAuthority("gestionnaire","admin")
                .antMatchers("/admin/**").hasAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
        //http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}
