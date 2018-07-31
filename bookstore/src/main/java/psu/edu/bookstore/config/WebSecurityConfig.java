package psu.edu.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import psu.edu.bookstore.service.bookstoreUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private bookstoreUserDetailsService bookstoreUserDetailsService;

    @Override
    public void configure(WebSecurity web) throws Exception {

        //
        //  don't need auth for viewing stylesheets!!!
        web.ignoring().antMatchers("/js/**","/css/**", "/images/**", "/img/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()

                // public pages
                .antMatchers("/", "/contact-us", "/about-us", "/console/**", "/api/**").permitAll()

                // authenticated pages
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                  .usernameParameter("username")
                  .passwordParameter("userpass")
                .permitAll()
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/logout-success")
                    .permitAll();

                // make this all work
                http.headers().frameOptions().disable();
                http.csrf().disable();

    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("admin")
//                .password("secretpassword")
//                .roles("USER");
        auth.userDetailsService(bookstoreUserDetailsService)
                .passwordEncoder(new PlaintextPasswordEncoder());
    }
}
