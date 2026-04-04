package com.example.securityApp.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.securityApp.entities.Myusers;

@SuppressWarnings("serial")
public class MyUserDetail implements UserDetails{
Myusers user;
	public MyUserDetail(Myusers user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.stream(user.getRole().split(",")).map(obj->new SimpleGrantedAuthority(obj)).collect(Collectors.toList());
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

}
