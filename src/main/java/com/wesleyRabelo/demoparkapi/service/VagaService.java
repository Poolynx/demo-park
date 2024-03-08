package com.wesleyRabelo.demoparkapi.service;

import com.wesleyRabelo.demoparkapi.entity.Vaga;
import com.wesleyRabelo.demoparkapi.exception.CodigoUniqueViolationException;
import com.wesleyRabelo.demoparkapi.exception.EntityNotFoundException;
import com.wesleyRabelo.demoparkapi.exception.VagaDisponivelException;
import com.wesleyRabelo.demoparkapi.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.wesleyRabelo.demoparkapi.entity.Vaga.StatusVaga.LIVRE;

@RequiredArgsConstructor
@Service
public class VagaService {
    private final VagaRepository repository;

    @Transactional
    public Vaga salvar(Vaga vaga){
        try{
            return repository.save(vaga);
        }catch(DataIntegrityViolationException e){
            throw new CodigoUniqueViolationException("Vaga", vaga.getCodigo());
        }
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo){
        return repository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException("Vaga", codigo)
        );
    }

    @Transactional(readOnly = true)
    public Vaga buscarPorVagaLivre() {
        return repository.findFirstByStatus(LIVRE).orElseThrow(
                () -> new VagaDisponivelException("Vaga")
        );
    }
}
