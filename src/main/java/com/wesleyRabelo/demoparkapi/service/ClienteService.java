package com.wesleyRabelo.demoparkapi.service;

import com.wesleyRabelo.demoparkapi.entity.Cliente;
import com.wesleyRabelo.demoparkapi.exception.CpfUniqueViolationException;
import com.wesleyRabelo.demoparkapi.exception.EntityNotFoundException;

import com.wesleyRabelo.demoparkapi.repository.ClienteRepository;
import com.wesleyRabelo.demoparkapi.repository.projection.ClienteProjection;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ClienteService {
    private final ClienteRepository repository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        try{
            return repository.save(cliente);
        } catch(DataIntegrityViolationException e){
            throw new CpfUniqueViolationException(
                    String.format("CPF '%s' não pode ser cadastro, já existe no sistema", cliente.getCpf())
            );
        }
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Cliente id=%s não encontrado", id))
        );
    }

    @Transactional(readOnly = true)
    public Page<ClienteProjection> buscarTodos(Pageable pageable) {
        return repository.findAllPageable(pageable);
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorUsuarioId(Long id) {
        return repository.findByUsuarioId(id);
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorCpf(String cpf) {
        return repository.findByCpf(cpf).orElseThrow(
                () -> new EntityNotFoundException(String.format("Cliente com CPF '%s' não encontrado", cpf))
        );
    }
}
