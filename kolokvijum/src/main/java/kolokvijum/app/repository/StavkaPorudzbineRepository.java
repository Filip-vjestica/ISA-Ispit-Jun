package kolokvijum.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kolokvijum.app.model.StavkaPorudzbine;

@Repository
public interface StavkaPorudzbineRepository extends PagingAndSortingRepository<StavkaPorudzbine, Long>{

}
