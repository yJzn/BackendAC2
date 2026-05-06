package com.example.projetoac2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.projetoac2.dtos.ProjetoDTO;
import com.example.projetoac2.services.ProjetoControleService;

@RestController
@RequestMapping("/projetos")
@CrossOrigin("*")
public class ProjetoController {

    @Autowired
    private ProjetoControleService service;

    @GetMapping
    public List<ProjetoDTO> obterTodos() {
        return service.listarProjetos();
    }

    @GetMapping("/{id}")
    public ProjetoDTO obterPorId(@PathVariable Long id) {
        return service.buscarProjetoPorIdDTO(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody ProjetoDTO dto) {
        service.adicionarProjeto(dto);
    }

    @PostMapping("/{idProjeto}/funcionarios/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void vincularFuncionario(
            @PathVariable Long idProjeto,
            @PathVariable Long idFuncionario) {

        service.vincularFuncionario(idProjeto, idFuncionario);
    }
}