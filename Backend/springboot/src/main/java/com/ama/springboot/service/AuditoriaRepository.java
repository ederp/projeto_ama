package com.ama.springboot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ama.springboot.model.Auditoria;

public interface AuditoriaRepository extends JpaRepository<Auditoria, Integer> {

}
