package br.com.cachorro.service;

import br.com.cachorro.model.CachorroModel;
import br.com.cachorro.repository.CachorroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CachorroService {

    @Autowired
    private CachorroRepository repository;

    public Optional<CachorroModel> findById(long id){
        return repository.findById(id);
    }

    public Page<CachorroModel> findAll(Pageable pageable){
        return repository.findAll(pageable);
    }

    public CachorroModel save(CachorroModel model){
        return repository.save(model);
    }

    public CachorroModel update(CachorroModel model){
        var found = repository.findById(model.getId());
        if(found.isPresent()){
            found.get().setName(model.getName());
            found.get().setCor(model.getCor());
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

    public List<CachorroModel> findByCor(String cor){
        return repository.findByCorStartsWithIgnoreCase(cor);
    }


}
