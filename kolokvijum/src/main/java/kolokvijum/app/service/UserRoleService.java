package kolokvijum.app.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kolokvijum.app.model.UserRole;
import kolokvijum.app.repository.UserRoleRepository;

@Service
public class UserRoleService {
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	public Set<UserRole> getRoleByUserId(Long id){
		return userRoleRepository.getById(id);
	}

}
