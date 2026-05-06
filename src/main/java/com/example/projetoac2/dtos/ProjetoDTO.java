package com.example.projetoac2.dtos;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class ProjetoDTO {
    private Long id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<String> funcionarios;
}