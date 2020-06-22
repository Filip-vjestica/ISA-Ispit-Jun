package kolokvijum.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import kolokvijum.app.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
	Optional<User> getByUsername(String username);
	Optional<User> getByUsernameAndPassword(String username, String password);

}
