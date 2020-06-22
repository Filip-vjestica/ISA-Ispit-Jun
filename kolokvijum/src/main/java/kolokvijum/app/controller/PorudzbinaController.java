package kolokvijum.app.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import kolokvijum.app.model.Porudzbina;

@Controller
@RequestMapping(path = "/api/porudzbina")
@CrossOrigin(origins = "*")
@Secured("ROLE_REGISTROVAN")
public class PorudzbinaController extends CRUDController <Porudzbina, Long>{

}
