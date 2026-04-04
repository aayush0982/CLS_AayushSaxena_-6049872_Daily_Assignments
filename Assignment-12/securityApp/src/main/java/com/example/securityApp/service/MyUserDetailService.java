package com.example.securityApp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securityApp.entities.Myusers;
import com.example.securityApp.repository.MyUsersRepo;
@Service
public class MyUserDetailService implements UserDetailsService{
	@Autowired
	MyUsersRepo myUsersRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Myusers> op=myUsersRepo.findById(username);
		if(op.isPresent())
		{
			Myusers user=op.get();
			return new MyUserDetail(user);
		}
		else
			throw new UsernameNotFoundException("User Not Found");
	}
}
