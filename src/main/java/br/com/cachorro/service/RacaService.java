package br.com.cachorro.service;

import br.com.cachorro.model.RacaModel;
import br.com.cachorro.repository.RacaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RacaService {

    @Autowired
    private RacaRepository repository;

    public Page<RacaModel> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public Optional<RacaModel> findById(long id){
        return repository.findById(id);
    }

    public RacaModel save(RacaModel model){
        return repository.save(model);
    }

    public RacaModel update(RacaModel model){
        var found = repository.findById(model.getId());
        if(found.isPresent()){
            found.get().setName(model.getName());
            return repository.save(found.get());
        } else {
            return null;
        }
    }

    public void delete(long id){
        var found = repository.findById(id);
        if(found.isPresent()){
            repository.delete(found.get());
        }
    }

}

