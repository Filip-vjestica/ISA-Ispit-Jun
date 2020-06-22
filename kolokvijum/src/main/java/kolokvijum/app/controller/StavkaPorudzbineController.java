package kolokvijum.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import kolokvijum.app.model.StavkaPorudzbine;

@Controller
@RequestMapping(path = "/api/stavkaPorudzbine")
@CrossOrigin(origins = "*")
public class StavkaPorudzbineController extends CRUDController <StavkaPorudzbine, Long >{

}
