package com.mercadolibre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.entity.AlunoComNotas;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoComNotas, Long> {

}
