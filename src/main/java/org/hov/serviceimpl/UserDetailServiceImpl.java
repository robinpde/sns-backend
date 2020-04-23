package org.hov.serviceimpl;

import org.hov.model.User;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService{
	@Autowired
	UserService userService;

    @Transactional(readOnly = true)
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println(username + "******************************************************");
	    User user =  userService.getUserByEmail(username);
	    UserBuilder builder = null;
	    if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(user.getFirstName());
			builder.disabled(!user.isActive());
			builder.password(user.getPassword());
			String[] authorities = new String[]{user.getUserType().toString()} ;
			
			builder.authorities(authorities);
	    } 
	    else {
	    	throw new UsernameNotFoundException("User not found.");
	    }
    	return builder.build();
	}
}