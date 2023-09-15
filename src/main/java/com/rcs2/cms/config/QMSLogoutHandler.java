package com.rcs2.cms.config;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import com.rcs2.cms.model.User;
import com.rcs2.cms.repository.UserRepository;

@Component
public class QMSLogoutHandler  implements LogoutHandler{
	@Autowired
	private UserRepository UserRepository;
	
	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		Object principal = authentication.getPrincipal();
		
		String username="";
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		if(username != "") {
			User user=UserRepository.findByUsername(username);
			System.out.println("Logout : " + user);
		}
		
	}

	

}
