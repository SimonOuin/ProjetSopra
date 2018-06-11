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
import com.example.demo.model.Competence;
import com.example.demo.model.CompetencePk;
import com.example.demo.model.Formation;
import com.example.demo.repository.CompetenceRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/competence")
@CrossOrigin(origins = "*")
public class CompetenceRestController {

	@Autowired
	private CompetenceRepository competenceRepository;

	@RequestMapping(path = { "/competence", "/competence/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createCompetence(@RequestBody Competence competence, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (competence.getKey() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			competenceRepository.save(competence);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/competence/{key}").buildAndExpand(competence.getKey()).toUri());
																												
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/competence", "/competence/" }, method = RequestMethod.PUT)
	public ResponseEntity<Competence> updateCompetence(@RequestBody Competence competence, BindingResult br) {
		ResponseEntity<Competence> response = null;
		if (competence.getKey() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Competence> opt = competenceRepository.findByKey(competence.getKey());
		if (opt.isPresent()) {
			Competence competenceEnBase = opt.get();
			competenceEnBase.setNiveau(competence.getNiveau());

			competenceRepository.save(competenceEnBase);
			response = new ResponseEntity<Competence>(opt.get(), HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@RequestMapping(value = "/{key}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCompetence(@PathVariable(name = "key") CompetencePk key) {
		Optional<Competence> opt = competenceRepository.findByKey(key);
		if (opt.isPresent()) {
			competenceRepository.deleteByKey(key);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Competence>> findAll() {
		return new ResponseEntity<List<Competence>>(competenceRepository.findAll(), HttpStatus.OK);
	}

	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{key}", method = RequestMethod.GET)
	public ResponseEntity<Competence> findByKey(@PathVariable(name = "key") CompetencePk key) {
		Optional<Competence> opt = competenceRepository.findByKey(key);
		if (opt.isPresent()) {
			return new ResponseEntity<Competence>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{niveau}", method = RequestMethod.GET)
	public ResponseEntity<Competence> findByNiveau(@PathVariable(name = "niveau") String niveau) {
		Optional<Competence> opt = competenceRepository.findByNiveau(niveau);
		if (opt.isPresent()) {
			return new ResponseEntity<Competence>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
