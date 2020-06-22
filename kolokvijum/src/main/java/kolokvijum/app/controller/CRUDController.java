package kolokvijum.app.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum.app.DTO.DTO;
import kolokvijum.app.model.NapraviDTO;
import kolokvijum.app.service.CRUDService;

public class CRUDController <T extends NapraviDTO, ID> {
	
	@Autowired
	protected CRUDService<T, ID> crudService;

	public CRUDService<T, ID> getCrudService() {
		return crudService;
	}

	public void setCrudService(CRUDService<T, ID> crudService) {
		this.crudService = crudService;
	}
	
	@RequestMapping(path="", method = RequestMethod.GET)
	public ResponseEntity<Page<DTO>> findAll(Pageable pageable){
		Page<DTO> page = this.crudService.findAll(pageable).map(t -> t.getDTO(false));
		return new ResponseEntity<Page<DTO>> (page, HttpStatus.OK);
	}
	
	@RequestMapping(path="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> findOne(@PathVariable("id") ID id) {
		Optional<T> t = this.crudService.findOne(id);
		if(t.isPresent()) {
			return new ResponseEntity<DTO>(t.get().getDTO(false), HttpStatus.OK);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestBody T noviEntitet) {
	if (noviEntitet.getId() != null) {
	    Optional<T> t = this.crudService.findOne((ID)noviEntitet.getId());

	    if (t.isEmpty()) {
		this.crudService.save(noviEntitet);
		return new ResponseEntity<DTO>(noviEntitet.getDTO(false), HttpStatus.CREATED);
	    } else {
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	    }
	} else {
	    this.crudService.save(noviEntitet);
	    return new ResponseEntity<DTO>(noviEntitet.getDTO(false), HttpStatus.CREATED);
	}
    }
	
	
	 @RequestMapping(path = "", method = RequestMethod.PUT)
	    public ResponseEntity<?> update(@RequestBody T noviEntitet) {
		if (noviEntitet.getId() != null) {

		    Optional<T> t = this.crudService.findOne((ID)noviEntitet.getId());

		    if (t.isPresent()) {
			this.crudService.save(noviEntitet);
			return new ResponseEntity<DTO>(t.get().getDTO(false), HttpStatus.OK);
		    } else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		    }
		} else {
		    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	    }
	 
	 @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	    public ResponseEntity<?> delete(@PathVariable("id") ID id) {
		Optional<T> t = this.crudService.findOne(id);

		if (t.isPresent()) {
		    this.crudService.delete(t.get());
		    return new ResponseEntity<Void>(HttpStatus.OK);
		} else {
		    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	    }
	 
	 @RequestMapping(path = "", method = RequestMethod.DELETE)
	    public ResponseEntity<?> delete(@RequestBody T noviEntitet) {
		if (noviEntitet.getId() != null) {
		    Optional<T> t = this.crudService.findOne((ID)noviEntitet.getId());

		    if (t.isPresent()) {
			this.crudService.delete(t.get());
			return new ResponseEntity<Void>(HttpStatus.OK);
		    } else {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		    }
		} else {
		    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
	    }

}
