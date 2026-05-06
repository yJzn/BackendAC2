package com.example.projetoac2.dtos;

import java.util.List;

import lombok.Data;

@Data
public class SetorDTO {
    private Long id;
    private String nome;
    private List<String> funcionarios;
}