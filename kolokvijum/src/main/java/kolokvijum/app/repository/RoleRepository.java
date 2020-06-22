package kolokvijum.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum.app.model.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
