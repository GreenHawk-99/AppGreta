package com.cda.contenu_seance.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Bean
    public BCryptPasswordEncoder bCryptPE(){
        return  new BCryptPasswordEncoder();
    }*/

    /*@Override
    protected void configure(AuthenticationManagerBuilder authBuilder)
        throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        authBuilder.inMemoryAuthentication()
                .withUser("eric.sejourne@ac-creteil.fr")
                .password(encoder.encode("123"))
                .authorities("coordonateur");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home", "/h2-console", "/h2-console/**", "/webjars/bootstrap/5.1.3/**", "/static/**").permitAll()
                .antMatchers("/formateur/**", "/welcome").hasAnyAuthority("Formateur","Coordinateur")
                .antMatchers("/coordonateur/**").hasAnyAuthority("Coordinateur")
                .antMatchers("/admin/**").hasAnyAuthority("Coordinateur")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/welcome", true)
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .permitAll()
                .and()
                .csrf().ignoringAntMatchers("/h2-console/**");
        http.headers().frameOptions().disable();
    }
}
