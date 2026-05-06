package com.example.projetoac2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.projetoac2.dtos.SetorDTO;
import com.example.projetoac2.services.ProjetoControleService;

@RestController
@RequestMapping("/setores")
public class SetorController {

    @Autowired
    private ProjetoControleService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void salvar(@RequestBody SetorDTO dto) {
        service.adicionarSetor(dto);
    }

    @GetMapping("/{id}")
    public SetorDTO buscarPorId(@PathVariable Long id) {
        return service.buscarSetorPorIdDTO(id);
    }
}