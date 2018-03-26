package org.nedezkiiyasen.uha.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

import static org.springframework.http.HttpMethod.POST;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select name, password, true from eptituders where name=?")
            .authoritiesByUsernameQuery("select name, role from eptituders where name=?")
            .passwordEncoder(new BCryptPasswordEncoder());
        System.out.println(new BCryptPasswordEncoder().encode("123"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/").permitAll()
            .antMatchers(POST, "/events/**").hasRole("ADMIN")
            .antMatchers(POST, "/eptituders/**", "/clans/**").hasRole("USER")
            .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
            .and()
                .csrf().disable();
    }
}
