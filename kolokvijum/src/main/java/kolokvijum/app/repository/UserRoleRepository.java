package kolokvijum.app.repository;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import kolokvijum.app.model.UserRole;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
	Set<UserRole> getById(Long id);

}
