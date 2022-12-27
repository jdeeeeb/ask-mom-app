package com.jdeeb.askmom.config.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

	@Value("${jwt.secret}")
	private String jwtSecret;
	
	public String generateToken(String login) {
//		Date date = Date.from(LocalDate.now().plusDays(15).atStartOfDay(ZoneId.systemDefault()).toInstant());
//		return Jwts.builder().setSubject(login).setExpiration(date).signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
		return Jwts.builder().setSubject(login).signWith(SignatureAlgorithm.HS512, jwtSecret.getBytes()).compact();
	}

	public boolean validateToken(String token) {
		try {
//			System.out.println(" Token :" + token);
//			System.out.println(" JWT secret :" + jwtSecret);
			Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
//            logger.severe("invalid token");
			e.printStackTrace();
//			System.out.println(" Wrong Token: " + token);
		}
		return false;
	}

	public String getLoginFromToken(String token) {
		Claims claims = Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
