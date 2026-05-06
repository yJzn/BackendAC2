package com.example.projetoac2.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.projetoac2.models.Projeto;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    @Query("""
        SELECT p FROM Projeto p
        LEFT JOIN FETCH p.funcionarios
        WHERE p.id = :id
    """)
    Optional<Projeto> buscarProjetoComFuncionarios(@Param("id") Long id);

    List<Projeto> findByDataInicioBetween(LocalDate dataInicio, LocalDate dataFim);
}