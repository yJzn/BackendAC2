package com.example.projetoac2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.projetoac2.models.Funcionario;
import com.example.projetoac2.models.Projeto;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    @Query("SELECT f.projetos FROM Funcionario f WHERE f.id = :id")
    List<Projeto> buscarProjetos(Long id);
}