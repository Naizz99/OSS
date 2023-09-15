package com.rcs2.cms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private QmsAuthenticationSuccessHandler successHandler;
	
	@Autowired
	private QMSLogoutHandler logoutHandler;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/", "/login","/issuer","/api/**","/websocket/**","/images/**").permitAll()
				.antMatchers("/scanner").hasAuthority("USER")
				.antMatchers("/secure/**").hasAuthority("ADMIN")
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.successHandler(successHandler)
				.and()
				.csrf().ignoringAntMatchers("/api/**")
				.and()
		        .logout().permitAll()
		        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		        .addLogoutHandler(logoutHandler)
		        .invalidateHttpSession(true)
		        .clearAuthentication(true)
		        .deleteCookies("JSESSIONID")		                
		        .logoutSuccessUrl("/login?logout")
		        .and().exceptionHandling().accessDeniedPage("/access_denied");
	}
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/sec/**","/resources/**", "/static/**", "/vendor/**","/css/**", "/js/**","/img/**","/file/**", "/webjars/**", "/bootstrap-5.0.2-dist/**", "/bootstrap/**");
    }
}
