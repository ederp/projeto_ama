package com.ama.springboot.service;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Jwts.SIG;

@Component
public class JwtTokenUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4945902026852767319L;

	private final SecretKey secret_key = Jwts.SIG.HS256.key().build();
	private long accessTokenValidity = 5*60*1000;

	private final JwtParser jwtParser;

	private final String TOKEN_HEADER = "Authorization";
	private final String TOKEN_PREFIX = "Bearer ";

	public JwtTokenUtil(){
		this.jwtParser = Jwts.parser().verifyWith(secret_key).build();
	}

	public String createToken(UserDetails usuario) {
		Claims claims = Jwts.claims().subject(usuario.getUsername()).build();
		Date tokenCreateTime = new Date();
		Date tokenValidity = new Date(tokenCreateTime.getTime() + TimeUnit.MINUTES.toMillis(accessTokenValidity));
		return Jwts.builder()
				.claims(claims)
				.expiration(tokenValidity)
				.signWith(secret_key, SIG.HS256)
				.compact();
	}

	private Claims parseJwtClaims(String token) {
		return jwtParser.parseSignedClaims(token).getPayload();
	}

	public Claims resolveClaims(HttpServletRequest req) {
		try {
			String token = this.resolveToken(req);
			if (token != null) {
				return this.parseJwtClaims(token);
			}
			return null;
		} catch (ExpiredJwtException ex) {
			req.setAttribute("expirado", ex.getMessage());
			throw ex;
		} catch (Exception ex) {
			req.setAttribute("inválido", ex.getMessage());
			throw ex;
		}
	}

	public String resolveToken(HttpServletRequest request) {

		String bearerToken = request.getHeader(TOKEN_HEADER);
		if (bearerToken != null && bearerToken.startsWith(TOKEN_PREFIX)) {
			return bearerToken.substring(TOKEN_PREFIX.length());
		}
		return null;
	}

	public boolean validateClaims(Claims claims) throws AuthenticationException {
		try {
			return claims.getExpiration().after(new Date());
		} catch (Exception e) {
			throw e;
		}
	}

	public String getUsername(Claims claims) {
		return claims.getSubject();
	}
	
}
