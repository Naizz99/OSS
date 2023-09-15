/**
 * 
 */
package com.rcs2.cms.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class QmsAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean isAdmin = false;
		boolean isCustomer = false;
		boolean isGuest = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		for (GrantedAuthority grantedAuthority : authorities) {
			if (grantedAuthority.getAuthority().equals("ADMIN")) {
				isAdmin = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("CUSTOMER")) {
				isCustomer = true;
				break;
			} else if (grantedAuthority.getAuthority().equals("GUEST")) {
				isGuest = true;
				break;
			}
		}

		if (isAdmin) {
			redirectStrategy.sendRedirect(request, response, "/secure/home");
		} else if (isCustomer) {
			redirectStrategy.sendRedirect(request, response, "/");
		} else if (isGuest) {
			redirectStrategy.sendRedirect(request, response, "/");
		} else {
			throw new IllegalStateException();
		}

	}

}
