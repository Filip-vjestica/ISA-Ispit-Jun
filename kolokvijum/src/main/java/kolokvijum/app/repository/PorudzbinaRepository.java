package kolokvijum.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import kolokvijum.app.model.Porudzbina;

@Repository
public interface PorudzbinaRepository extends PagingAndSortingRepository<Porudzbina, Long>{

}
