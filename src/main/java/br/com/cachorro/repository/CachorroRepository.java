package br.com.cachorro.repository;

import br.com.cachorro.model.CachorroModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CachorroRepository extends JpaRepository<CachorroModel, Long> {

    Optional<CachorroModel> findById(long id);
    public Page<CachorroModel> findAll(Pageable pageable);
    List<CachorroModel> findByNameContainsIgnoreCaseOrderByName(String name);
    //..new methods of V2
    List<CachorroModel>findByCorStartsWithIgnoreCase(String cor);

}



