package com.example.demo.restController;

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
import com.example.demo.model.Formation;
import com.example.demo.repository.FormationRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/formation")
@CrossOrigin(origins = "*")
public class FormationRestController {

	@Autowired
	private FormationRepository formationRepository;

	@RequestMapping(path = { "/formation", "/formation/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createFormation(@RequestBody Formation formation, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (formation.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			formationRepository.save(formation);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/formation/{id}").buildAndExpand(formation.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/formation", "/formation/" }, method = RequestMethod.PUT)
	public ResponseEntity<Formation> updateFormation(@RequestBody Formation formation, BindingResult br) {
		ResponseEntity<Formation> response = null;
		if (formation.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Formation> opt = formationRepository.findById(formation.getId());
		if (opt.isPresent()) {
			Formation formationEnBase = opt.get();
			formationEnBase.setStagiaires(formation.getStagiaires());
			formationEnBase.setModules(formation.getModules());
			formationEnBase.setDateDebut(formation.getDateDebut());
			formationEnBase.setDateFin(formation.getDateFin());

			formationRepository.save(formationEnBase);
			response = new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Formation>> findAll() {
		return new ResponseEntity<List<Formation>>(formationRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Formation> findById(@PathVariable(name = "id") Long id) {
		Optional<Formation> opt = formationRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Formation>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
