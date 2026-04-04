package com.example.securityApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.securityApp.service.MyUserDetailService;

@SpringBootApplication
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityAppApplication {
	@Autowired
	MyUserDetailService myUserDetailService;

	public static void main(String[] args) {
		SpringApplication.run(SecurityAppApplication.class, args);
	}

//	@Bean
	// This method defines the security filter chain for the application. It
	// configures HTTP security settings, such as disabling CSRF protection
	// (suitable for REST APIs), requiring authentication for all requests, and
	// setting up HTTP Basic authentication. The method also specifies the
	// authentication provider to be used.
//	public SecurityFilterChain webSecurityFilter(HttpSecurity http) {
//		return http.csrf(csrf -> csrf.disable()) // For REST API
//				.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//				.authenticationProvider(getAuthenticationProvider()).httpBasic(Customizer.withDefaults()).build();
//	}
	@Bean
	public SecurityFilterChain webSecurityFilter(HttpSecurity http) {
		return http.csrf(csrf -> csrf.disable()) // For REST API
				.authorizeHttpRequests(authReq -> authReq.requestMatchers(HttpMethod.GET, "/publicEndPoint").permitAll()
						.anyRequest().authenticated())
				.authenticationProvider(getAuthenticationProvider()).httpBasic(Customizer.withDefaults()).build();
	}

	@SuppressWarnings("deprecation")
	@Bean
	public DaoAuthenticationProvider getAuthenticationProvider() {
		DaoAuthenticationProvider dao = new DaoAuthenticationProvider(myUserDetailService);
		dao.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		// getinstance() is a static method that returns a singleton instance of
		// NoOpPasswordEncoder. This means that the same instance will be used
		// throughout the application, ensuring that password encoding and decoding are
		// consistent. NoOpPasswordEncoder is a password encoder that performs no
		// encoding, meaning
		// it simply returns the raw password as is. This is not recommended for
		// production use, as it does not provide any security for password storage.
		return dao;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		// this is used to encode the password in the database and compare it with the
		// password provided by the user during authentication. BCrypt is a strong
		// hashing algorithm that provides good security for password storage.
	}
}
