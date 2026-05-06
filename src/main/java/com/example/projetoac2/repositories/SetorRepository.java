package com.example.projetoac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projetoac2.models.Setor;

public interface SetorRepository extends JpaRepository<Setor, Long> {

    @Query("SELECT s FROM Setor s LEFT JOIN FETCH s.funcionarios")
    List<Setor> buscarSetoresComFuncionarios();
}