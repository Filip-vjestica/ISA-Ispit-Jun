package kolokvijum.app.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.stereotype.Repository;


import kolokvijum.app.model.User;

@Repository
public interface KorisnikRepository extends PagingAndSortingRepository<User, Long> {

}
