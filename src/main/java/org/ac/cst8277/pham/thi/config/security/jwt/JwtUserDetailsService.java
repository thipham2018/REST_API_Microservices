package org.ac.cst8277.pham.thi.config.security.jwt;

import org.ac.cst8277.pham.thi.config.security.UserManagementService;
import org.ac.cst8277.pham.thi.dao.UserHasRoleRepository;
import org.ac.cst8277.pham.thi.dao.UserRepository;
import org.ac.cst8277.pham.thi.dto.Roles;
import org.ac.cst8277.pham.thi.dto.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserHasRoleRepository userHasRoleRepository;

	@Autowired
	private UserManagementService userManagementService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found: " + email);
		}
		userManagementService.createSessionLogin(email);
		return new org.springframework.security.core.userdetails.User(email, user.getPassword(), new ArrayList<>());
	}

	public UserDetails loadUserByEmail(String email) throws UsernameNotFoundException{
		Users user = userRepository.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("Email not found: " + email);
		}
		return new org.springframework.security.core.userdetails.User(email, user.getPassword(), new ArrayList<>());
	}
}