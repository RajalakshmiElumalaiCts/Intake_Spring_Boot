package com.intake.jwt;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
	
	@Value("${jwt.secret}")
	private String secret_key;
	
	//Keeping 1 hr exp time for a token
	private static final long JWT_EXP_TOKEN = 1000* 1 * 60 * 60;
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
		
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());		
	}

	private String createToken(Map<String, Object> claims, String username) {
		
		return Jwts.builder().addClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_EXP_TOKEN))
				.signWith(SignatureAlgorithm.HS512, secret_key).compact();
	}
	
	public boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}

	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		 final Claims claims = extractAllClaims(token);
	     return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(secret_key).parseClaimsJws(token).getBody();
	}

}
