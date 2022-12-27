package com.jdeeb.askmom.config.jwt;

import static org.springframework.util.StringUtils.hasText;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.jdeeb.askmom.config.CustomUserDetails;
import com.jdeeb.askmom.config.CustomUserDetailsService;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
@Component
public class JwtFilter extends GenericFilterBean {

	public static final String AUTHORIZATION = "Authorization";

	@Autowired
	private JwtProvider jwtProvider;

	@Lazy
	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
//		logger.info("do filter...");
		String token = getTokenFromRequest((HttpServletRequest) servletRequest);
//		System.out.println("TOKEN >>>>>>>>>>>>>>>>>>>>>>>>>>>>>> " + token);
		if (token != null && jwtProvider.validateToken(token)) {
			String userLogin = jwtProvider.getLoginFromToken(token);
			CustomUserDetails customUserDetails = customUserDetailsService.loadUserByUsername(userLogin);
			UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customUserDetails, null,
					customUserDetails.getAuthorities());
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
		
		
		
//		HttpServletRequest request = (HttpServletRequest) servletRequest;
//	    HttpServletResponse response = (HttpServletResponse) servletResponse;

	    
//	    System.out.println("Request Come From " + request.getHeader("Origin"));
//	    System.out.println(request.getRequestURI());
	    
//	    response.setHeader("Access-Control-Allow-Origin", "*");
//	    response.setHeader("Access-Control-Allow-Credentials", "true");
//	    response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
//	    response.setHeader("Access-Control-Max-Age", "3600");
//	    response.setHeader("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, remember-me, Authorization");

		filterChain.doFilter(servletRequest, servletResponse);
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		String bearer = request.getHeader(AUTHORIZATION);
//		System.out.println("Bearer >>>>>>>>>>>>>>>>>>>>>>>>>> " + bearer);
		if (hasText(bearer) && bearer.startsWith("Bearer ")) {
			return bearer.substring(7);
		}
		return null;
	}
}
