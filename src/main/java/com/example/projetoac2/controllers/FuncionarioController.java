package com.example.projetoac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.projetoac2.dtos.FuncionarioDTO;
import com.example.projetoac2.dtos.ProjetoDTO;
import com.example.projetoac2.services.ProjetoControleService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    @Autowired
    private ProjetoControleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody FuncionarioDTO dto) {
        service.adicionarFuncionario(dto);
    }

    @GetMapping("/{id}/projetos")
    public List<ProjetoDTO> buscarProjetos(@PathVariable Long id) {
        return service.buscarProjetosDoFuncionarioDTO(id);
    }
}