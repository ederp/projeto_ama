package com.ama.springboot.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import com.ama.springboot.model.RefreshToken;
import com.ama.springboot.model.Usuario;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer> {

	Optional<RefreshToken> findByToken(String token);

	@Modifying
	int deleteByUsuario(Usuario usuario);
}
