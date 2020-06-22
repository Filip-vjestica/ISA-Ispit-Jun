package kolokvijum.app.service;

import java.util.ArrayList;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kolokvijum.app.model.User;
import kolokvijum.app.model.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserService  userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userService.getUser(username);
		
		if(user.isPresent()) {
			ArrayList<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
			for(UserRole up : user.get().getUserRole()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(up.getRole().getTitle()));
			}
			
			return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);
		}
		
		return null;
	}

}
