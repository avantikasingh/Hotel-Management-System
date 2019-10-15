package com.cg.hotelmanagement.dto;

import java.io.IOException;
import java.security.Principal;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.cg.hotelmanagement.service.CustomerService;

public class HCSAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	HttpSession session;

	@Autowired
	CustomerService service;

	private static final Logger logger = LoggerFactory.getLogger(HCSAuthenticationSuccessHandler.class);

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String loginName="";

		if(authentication.getPrincipal() instanceof Principal) {
			loginName=((Principal)authentication.getPrincipal()).getName();
		}else {
			loginName=((UserDetailsImpl)authentication.getPrincipal()).getUsername();
		}

		System.out.println("loginName: "+loginName);
		
			session.setAttribute("user", service.getCustomer(loginName));
		
		handle(request, response, authentication);
		clearAuthenticationAttributes(request);
	}


	protected void handle(HttpServletRequest request, 
			HttpServletResponse response, Authentication authentication)
					throws IOException {
		System.out.println("target url verify");
		String targetUrl = determineTargetUrl(authentication);
		System.out.println(targetUrl);
		if (response.isCommitted()) {
			logger.debug(
					"Response has already been committed. Unable to redirect to "
							+ targetUrl);
			return;
		}

		redirectStrategy.sendRedirect(request, response, targetUrl);
	}


	protected String determineTargetUrl(Authentication authentication) {
		boolean isUser = false;
		boolean isAdmin = false;
		System.out.println("inside handler");
		Collection<? extends GrantedAuthority> authorities
		= authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println(grantedAuthority.getAuthority());
			if (grantedAuthority.getAuthority().equals("USER")) {
				isUser = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("ADMIN")) {
				isAdmin = true;
				break;
			}
		}
		System.out.println(isUser+" "+isAdmin);
		if (isUser) {
			return "/customer/home";
		} else if (isAdmin) {
			return "/admin/home";
		} else {
			throw new IllegalStateException();
		}
	}


	protected void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session == null) {
			return;
		}
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}


	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}


	protected RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

}
