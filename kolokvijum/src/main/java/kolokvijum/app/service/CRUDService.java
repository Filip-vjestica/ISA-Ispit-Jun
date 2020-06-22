package kolokvijum.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public class CRUDService <T,ID>{
	
	@Autowired
	protected PagingAndSortingRepository<T, ID> repository;

	public Page<T> findAll(Pageable pageable) {
		return this.repository.findAll(pageable);
	}

	public Iterable<T> findAll() {
		return this.repository.findAll();
	}

	public Optional<T> findOne(ID id) {
		return this.repository.findById(id);
	}

	public void save(T model) {
		this.repository.save(model);
	}

	public void deleteBy(ID id) {
		this.repository.deleteById(id);
	}

	public void delete(T t) {
		this.repository.delete(t);
	}

}
