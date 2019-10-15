package com.cg.hotelmanagement.service;

import java.util.ArrayList;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cg.hotelmanagement.dto.Customer;
import com.cg.hotelmanagement.dto.UserDetailsImpl;

import com.cg.hotelmanagement.repository.CustomerRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> user = userRepository.findByUsername(username);
		
		return user.map(UserDetailsImpl::new).get();
	}
	
	public Customer save(Customer user) {
//		User newUser = new User(brcyptEncoder.encode(user.getUserPassword()), user.getUserName(), user.getContactNo(), user.getUserEmail(), user.getAge(), user.getGender());
//		return userRepository.save(newUser);
		
		
		// Validating unique database columns
		Optional<Customer> checkUserCredentials = userRepository.findByUsername(user.getUsername());
		
		user.setRole("USER");
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);
		
	}
	
}