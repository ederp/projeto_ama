package com.ama.springboot.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ama.springboot.exception.TokenRefreshException;
import com.ama.springboot.model.RefreshToken;

@Service
public class RefreshTokenService {

	private Long refreshTokenDurationMs = 300000L;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<RefreshToken> findByToken(String token) {
	    return refreshTokenRepository.findByToken(token);
	  }

	  public RefreshToken createRefreshToken(String user) {
	    RefreshToken refreshToken = new RefreshToken();

	    refreshToken.setUsuario(usuarioRepository.findByUsuario(user));
	    refreshToken.setExpiryDate(Instant.now().plusMillis(refreshTokenDurationMs));
	    refreshToken.setToken(UUID.randomUUID().toString());

	    refreshToken = refreshTokenRepository.save(refreshToken);
	    return refreshToken;
	  }

	  public RefreshToken verifyExpiration(RefreshToken token) {
	    if (token.getExpiryDate().compareTo(Instant.now()) < 0) {
	      refreshTokenRepository.delete(token);
	      throw new TokenRefreshException(token.getToken(), "O refresh token foi expirado. Favor criar uma nova requisição");
	    }
	    return token;
	  }

	  @Transactional
	  public int deleteByUserId(Integer userId) {
	    return refreshTokenRepository.deleteByUsuario(usuarioRepository.findById(userId).get());
	  }
}
