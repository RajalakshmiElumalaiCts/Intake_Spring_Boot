package com.intake.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.intake.jwt.JwtUserDetailsService;
import com.intake.jwt.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private JwtUserDetailsService jwtUserDetailService;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		final String tokenHeader = request.getHeader("Authorization");
		String username = null;
		String jwtToken = null;
		
		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
		if(tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
			jwtToken = tokenHeader.substring(7);
			try {
				username = jwtUtil.extractUsername(jwtToken);
			}catch(ExpiredJwtException ex) {
				System.out.println("Jwt token has expired..");				
			}			
		}else {
			System.out.println("\"Invalid JWT Token passed..\"");
		}
		
		//Once we get the token validate it.
		if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = jwtUserDetailService.loadUserByUsername(username);
			
			// if token is valid configure Spring Security to manually set authentication
			if(jwtUtil.validateToken(jwtToken, userDetails)) {
				UsernamePasswordAuthenticationToken userPwdAuthToken = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				userPwdAuthToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(userPwdAuthToken);
			}			
			
		}
		filterChain.doFilter(request, response);		
	}

}
