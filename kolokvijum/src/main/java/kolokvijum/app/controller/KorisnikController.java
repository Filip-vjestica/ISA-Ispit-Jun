package kolokvijum.app.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import kolokvijum.app.model.User;

@Controller
@RequestMapping(path = "/api/korisnik")
@CrossOrigin(origins = "*")
public class KorisnikController extends CRUDController<User, Long>{

}
