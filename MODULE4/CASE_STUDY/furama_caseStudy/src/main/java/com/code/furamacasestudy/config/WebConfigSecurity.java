package com.code.furamacasestudy.config;

//import com.code.furamacasestudy.service.impl.UserDetailServiceImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
//import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

//@Configuration
//@EnableWebSecurity
//public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
//    @Autowired
//    private UserDetailServiceImpl userDetailService;
//
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // Sét đặt dịch vụ để tìm kiếm User trong Database.
//        // Và sét đặt PasswordEncoder.
//        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
//        http.authorizeRequests().antMatchers("/customer","/employee","/service","/contract","/contractDetail").hasAnyRole("ADMIN","EDITTOR","USERS");
//        http.authorizeRequests().antMatchers("/**/create","/**/edit/**","/**/save","/customer/delete/**","/contract/delete/**","/service/delete/**","/contractDetail/delete/**").hasAnyRole("EDITTOR","ADMIN");
//        http.authorizeRequests().antMatchers("/employee/delete/**").hasRole("ADMIN");
//        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/error-403");
//
//
//
//        http.formLogin().defaultSuccessUrl("/").and().logout().logoutSuccessUrl("/");
//        http.authorizeRequests().and().rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(24 * 60 * 60);
//
//    }
//    @Bean
//    public PersistentTokenRepository persistentTokenRepository() {
//        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
//        return memory;
//    }
//}
