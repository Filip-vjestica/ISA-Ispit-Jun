package kolokvijum.app.controller;

import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum.app.DTO.UserDTO;
import kolokvijum.app.model.User;
import kolokvijum.app.model.UserRole;
import kolokvijum.app.repository.RoleRepository;
import kolokvijum.app.repository.UserRepository;
import kolokvijum.app.service.UserService;
import kolokvijum.app.utils.TokenUtils;

@Controller
@RequestMapping("/api")
public class LoginController {
	
	@Autowired
	UserService serService;

	@Autowired
	UserRepository ur;

	@Autowired
	RoleRepository pr;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private TokenUtils tokenUtils;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public ResponseEntity<HashMap<String, String>> login(@RequestBody User korisnik) {
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(korisnik.getUsername(),
					korisnik.getPassword());
			
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			UserDetails details = userDetailsService.loadUserByUsername(korisnik.getUsername());
			String userToken = tokenUtils.generateToken(details);
			
			HashMap<String, String> data = new HashMap<String, String>();
			data.put("token", userToken);
			
			return new ResponseEntity<HashMap<String, String>>(data, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<HashMap<String, String>>(HttpStatus.UNAUTHORIZED);
		}
	}

	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> register(@RequestBody User korisnik) {
		korisnik.setPassword(passwordEncoder.encode(korisnik.getPassword()));

		korisnik = ur.save(korisnik);
		korisnik.setUserRole(new HashSet<UserRole>());
		korisnik.getUserRole().add(new UserRole(null, korisnik, pr.findById(1l).get()));
		ur.save(korisnik);

		return new ResponseEntity<UserDTO>(new UserDTO(korisnik), HttpStatus.OK);
	}

	@RequestMapping("/test")
	@PreAuthorize("hasAuthority('TEST')")
	public ResponseEntity<String> test() {
		return new ResponseEntity<String>("Test success!", HttpStatus.OK);
	}
	
	@RequestMapping("/test2")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<UserDetails> test2(@AuthenticationPrincipal UserDetails userDetails) {
		return new ResponseEntity<UserDetails>(userDetails, HttpStatus.OK);
	}
	
	@RequestMapping("/test3")
	@PreAuthorize("isAnonymous()")
	public ResponseEntity<String> test3() {
		return new ResponseEntity<String>("anonymous success!", HttpStatus.OK);
	}

}
