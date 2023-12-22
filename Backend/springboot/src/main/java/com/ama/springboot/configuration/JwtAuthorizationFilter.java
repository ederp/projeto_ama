package com.ama.springboot.configuration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;

@Component
public class JwtAuthorizationFilter extends OncePerRequestFilter{
	
	private final JwtTokenUtil jwtTokenUtil;
    private final ObjectMapper mapper;
    
    
	public JwtAuthorizationFilter(JwtTokenUtil jwtTokenUtil, ObjectMapper mapper) {
		super();
		this.jwtTokenUtil = jwtTokenUtil;
		this.mapper = mapper;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, Object> errorDetails = new HashMap<>();

        try {
            String accessToken = jwtTokenUtil.resolveToken(request);
            if (accessToken == null ) {
                filterChain.doFilter(request, response);
                return;
            }
            System.out.println("token : "+accessToken);
            Claims claims = jwtTokenUtil.resolveClaims(request);

            if(claims != null & jwtTokenUtil.validateClaims(claims)){
                String username = claims.getSubject();
                System.out.println("username : "+username);
                Authentication authentication =
                        new UsernamePasswordAuthenticationToken(username,"",new ArrayList<>());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }

        }catch (Exception e){
            errorDetails.put("message", "Authentication Error");
            errorDetails.put("details",e.getMessage());
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);

            mapper.writeValue(response.getWriter(), errorDetails);

        }
        filterChain.doFilter(request, response);
    }
	
}
