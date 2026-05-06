package com.example.projetoac2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.projetoac2.dtos.FuncionarioDTO;
import com.example.projetoac2.dtos.ProjetoDTO;
import com.example.projetoac2.dtos.SetorDTO;
import com.example.projetoac2.models.Funcionario;
import com.example.projetoac2.models.Projeto;
import com.example.projetoac2.models.Setor;
import com.example.projetoac2.repositories.FuncionarioRepository;
import com.example.projetoac2.repositories.ProjetoRepository;
import com.example.projetoac2.repositories.SetorRepository;

@Service
public class ProjetoControleService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private SetorRepository setorRepository;

    //service projeto

    public List<ProjetoDTO> listarProjetos() {
        List<Projeto> projetos = projetoRepository.findAll();

        return projetos.stream().map(p -> {
            ProjetoDTO dto = new ProjetoDTO();
            dto.setId(p.getId());
            dto.setDescricao(p.getDescricao());
            dto.setDataInicio(p.getDataInicio());
            dto.setDataFim(p.getDataFim());
            return dto;
        }).toList();
    }

    public void adicionarProjeto(ProjetoDTO dto) {
        Projeto projeto = new Projeto();
        projeto.setDescricao(dto.getDescricao());
        projeto.setDataInicio(dto.getDataInicio());
        projeto.setDataFim(dto.getDataFim());

        projetoRepository.save(projeto);
    }

    public ProjetoDTO buscarProjetoPorIdDTO(Long id) {
        Projeto p = projetoRepository.buscarProjetoComFuncionarios(id).get();

        ProjetoDTO dto = new ProjetoDTO();
        dto.setId(p.getId());
        dto.setDescricao(p.getDescricao());
        dto.setDataInicio(p.getDataInicio());
        dto.setDataFim(p.getDataFim());

        dto.setFuncionarios(
            p.getFuncionarios()
                .stream()
                .map(f -> f.getNome())
                .toList()
        );

        return dto;
    }

    public void vincularFuncionario(Long idProjeto, Long idFuncionario) {
        Projeto projeto = projetoRepository.findById(idProjeto).get();
        Funcionario funcionario = funcionarioRepository.findById(idFuncionario).get();

        projeto.getFuncionarios().add(funcionario);
        projetoRepository.save(projeto);
    }

    //service funcionario

    public void adicionarFuncionario(FuncionarioDTO dto) {
        Funcionario f = new Funcionario();
        f.setNome(dto.getNome());

        funcionarioRepository.save(f);
    }

    public List<ProjetoDTO> buscarProjetosDoFuncionarioDTO(Long idFuncionario) {
        List<Projeto> projetos = funcionarioRepository.buscarProjetos(idFuncionario);

        return projetos.stream().map(p -> {
            ProjetoDTO dto = new ProjetoDTO();
            dto.setId(p.getId());
            dto.setDescricao(p.getDescricao());
            dto.setDataInicio(p.getDataInicio());
            dto.setDataFim(p.getDataFim());
            return dto;
        }).toList();
    }

    //service setor

    public void adicionarSetor(SetorDTO dto) {
        Setor setor = new Setor();
        setor.setNome(dto.getNome());

        setorRepository.save(setor);
    }

    public SetorDTO buscarSetorPorIdDTO(Long id) {
        Setor setor = setorRepository.findById(id).get();

        SetorDTO dto = new SetorDTO();
        dto.setId(setor.getId());
        dto.setNome(setor.getNome());

        dto.setFuncionarios(
            setor.getFuncionarios()
                .stream()
                .map(f -> f.getNome())
                .toList()
        );

        return dto;
    }
}