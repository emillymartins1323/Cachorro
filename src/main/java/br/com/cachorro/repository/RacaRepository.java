package br.com.cachorro.repository;

import br.com.cachorro.model.RacaModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacaRepository extends JpaRepository<RacaModel, Long> {

    Optional<RacaModel> findById(long id);

    public Page<RacaModel> findAll(Pageable pageable);


    List<RacaModel> findByNameContainsIgnoreCaseOrderByName(String name);
}