package com.cg.hotelmanagement.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.hotelmanagement.dto.HMSUrlAuthenticationSuccessHandler;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	UserDetailsService userDetailsService;
	
	@Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
            return super.authenticationManagerBean();
    }
	
	 	@Bean
	    public AuthenticationSuccessHandler hmsAuthenticationSuccessHandler(){
	        return new HMSUrlAuthenticationSuccessHandler();
	    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		
		http.authorizeRequests().antMatchers("/admin/login").permitAll()
		.antMatchers("/admin/home").hasRole("ADMIN")
		.antMatchers("/admin/addhotel").hasRole("ADMIN")
		.antMatchers("/admin/pagesubmitaddhotelpage").hasRole("ADMIN")
		.antMatchers("/admin/addroom").hasRole("ADMIN")
		.antMatchers("/admin/pagesubmitaddroompage").hasRole("ADMIN")
		.antMatchers("/admin/showcity").hasRole("ADMIN")
		.antMatchers("/admin/showhotel").hasRole("ADMIN")
		.antMatchers("/admin/showallhotel").hasRole("ADMIN")
		.antMatchers("/admin/showroom").hasRole("ADMIN")
		.antMatchers("/admin/showallroom").hasRole("ADMIN")
		.antMatchers("/admin/deltecity").hasRole("ADMIN")
		.antMatchers("/admin/deletecitydata").hasRole("ADMIN")
		.antMatchers("/admin/deltehotel").hasRole("ADMIN")
		.antMatchers("/admin/deletehoteldata").hasRole("ADMIN")
		.antMatchers("/admin/delteroom").hasRole("ADMIN")
		.antMatchers("/admin/deleteroomdata").hasRole("ADMIN")
		.antMatchers("/admin/updatehotel").hasRole("ADMIN")
		.antMatchers("/admin/updatehoteldata").hasRole("ADMIN")
		.antMatchers("/admin/updatehotelview").hasRole("ADMIN")
		.antMatchers("/admin/updateroom").hasRole("ADMIN")
		.antMatchers("/admin/updateroomdata").hasRole("ADMIN")
		.antMatchers("/admin/updateroomview").hasRole("ADMIN")
		.antMatchers("/customer/home").hasAnyRole("ADMIN", "USER")
		.antMatchers("/customer/register").hasAnyRole("ADMIN", "USER")
		.antMatchers("/customer/registerpage").hasAnyRole("ADMIN", "USER")
		.antMatchers("/customer/viewHotelsPage").hasAnyRole("ADMIN", "USER")
		.antMatchers("/customer/home").hasAnyRole("ADMIN", "USER")
		.antMatchers("/customer/ViewBooking").hasAnyRole("ADMIN", "USER")
		.antMatchers("/customer/BookingPage").hasAnyRole("ADMIN", "USER")
				.and().formLogin()
				.loginPage("/admin/login")
				.usernameParameter("username").passwordParameter("password")
				.successHandler(hmsAuthenticationSuccessHandler())
				.and().logout().logoutSuccessUrl("/").and().csrf().disable();
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

}