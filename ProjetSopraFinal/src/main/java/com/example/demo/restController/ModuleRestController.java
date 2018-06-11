package com.example.demo.restController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.jsonview.JsonViews;
import com.example.demo.model.Formateur;
import com.example.demo.model.Matiere;
import com.example.demo.model.Module;
import com.example.demo.model.Salle;
import com.example.demo.repository.ModuleRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/module")
@CrossOrigin(origins = "*")
public class ModuleRestController {

	@Autowired
	private ModuleRepository moduleRepository;

	@RequestMapping(path = { "/module", "/module/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createModule(@RequestBody Module module, BindingResult br, UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (module.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			moduleRepository.save(module);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/module/{id}").buildAndExpand(module.getId()).toUri());
		}

		return response;

	}

	@RequestMapping(path = { "/module", "/module/" }, method = RequestMethod.PUT)
	public ResponseEntity<Module> updateModule(@RequestBody Module module, BindingResult br) {
		ResponseEntity<Module> response = null;
		if (module.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Module> opt = moduleRepository.findById(module.getId());
		if (opt.isPresent()) {
			Module moduleEnBase = opt.get();
			moduleEnBase.setSalle(module.getSalle());
			moduleEnBase.setFormateur(module.getFormateur());
			moduleEnBase.setMatiere(module.getMatiere());
			moduleEnBase.setVideoProjecteur(module.getVideoProjecteur());
			moduleEnBase.setDateDebut(module.getDateDebut());
			moduleEnBase.setFormation(module.getFormation());
			moduleRepository.save(moduleEnBase);
			response = new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteModule(@PathVariable(name = "id") Long id){
		Optional<Module> opt = moduleRepository.findById(id);
		if (opt.isPresent()) {
			moduleRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Module>> findAll() {
		return new ResponseEntity<List<Module>>(moduleRepository.findAll(), HttpStatus.OK);

	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Module> findById(@PathVariable(name = "id") Long id) {
		Optional<Module> opt = moduleRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/salle/{salle}", method = RequestMethod.GET)
	public ResponseEntity<Module> findBySalle(@PathVariable(name = "salle") Salle salle) {
		Optional<Module> opt = moduleRepository.findBySalle(salle);
		if (opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/formateur/{formateur}", method = RequestMethod.GET)
	public ResponseEntity<Module> findByFormateur(@PathVariable(name = "formateur") Formateur formateur) {
		Optional<Module> opt = moduleRepository.findByFormateur(formateur);
		if (opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/matiere/{matiere}", method = RequestMethod.GET)
	public ResponseEntity<Module> findByMatiere(@PathVariable(name = "matiere") Matiere matiere) {
		Optional<Module> opt = moduleRepository.findByMatiere(matiere);
		if (opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/debut/{DateDebut}", method = RequestMethod.GET)
	public ResponseEntity<Module> findByDateDebut(@PathVariable(name = "DateDebut") Date DateDebut) {
		Optional<Module> opt = moduleRepository.findByDateDebut(DateDebut);
		if (opt.isPresent()) {
			return new ResponseEntity<Module>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
}
