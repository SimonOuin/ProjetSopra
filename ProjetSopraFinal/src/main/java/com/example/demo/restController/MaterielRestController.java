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
import com.example.demo.model.Formateur;
import com.example.demo.model.Materiel;
import com.example.demo.model.Ordinateur;
import com.example.demo.model.RessourceHumaine;
import com.example.demo.model.Salle;
import com.example.demo.model.VideoProjecteur;
import com.example.demo.repository.MaterielRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/materiel")
@CrossOrigin(origins = "*")
public class MaterielRestController {

	@Autowired
	private MaterielRepository materielRepository;

	@RequestMapping(path = { "/ordinateur", "/ordinateur/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createOrdinateur(@RequestBody Ordinateur ordinateur, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (ordinateur.getCode() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			materielRepository.save(ordinateur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/materiel/{code}").buildAndExpand(ordinateur.getCode()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/videoprojecteur", "/videoprojecteur/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createVideoProjecteur(@RequestBody VideoProjecteur videoProjecteur, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (videoProjecteur.getCode() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			materielRepository.save(videoProjecteur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/materiel/{code}").buildAndExpand(videoProjecteur.getCode()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/salle", "/salle/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createSalle(@RequestBody Salle salle, BindingResult br, UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (salle.getCode() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			materielRepository.save(salle);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/materiel/{code}").buildAndExpand(salle.getCode()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/ordinateur", "/ordinateur/" }, method = RequestMethod.PUT)
	public ResponseEntity<Materiel> updateOrdinateur(@RequestBody Ordinateur ordinateur, BindingResult br) {
		ResponseEntity<Materiel> response = null;
		if (ordinateur.getCode() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Materiel> opt = materielRepository.findById(ordinateur.getCode());
		if (opt.isPresent()) {
			Materiel materielEnBase = opt.get();
			materielEnBase.setCout(ordinateur.getCout());
			((Ordinateur) materielEnBase).setAnnee(ordinateur.getAnnee());
			((Ordinateur) materielEnBase).setDisqueDur(ordinateur.getDisqueDur());
			((Ordinateur) materielEnBase).setProcesseur(ordinateur.getProcesseur());
			((Ordinateur) materielEnBase).setRam(ordinateur.getRam());
			materielRepository.save(materielEnBase);
			response = new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(path = { "/videoprojecteur", "/videoprojecteur/" }, method = RequestMethod.PUT)
	public ResponseEntity<Materiel> updateVideoProjecteur(@RequestBody VideoProjecteur videoProjecteur,
			BindingResult br) {
		ResponseEntity<Materiel> response = null;
		if (videoProjecteur.getCode() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Materiel> opt = materielRepository.findById(videoProjecteur.getCode());
		if (opt.isPresent()) {
			Materiel materielEnBase = opt.get();
			materielEnBase.setCout(videoProjecteur.getCout());
			materielRepository.save(materielEnBase);
			response = new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(path = { "/salle", "/salle/" }, method = RequestMethod.PUT)
	public ResponseEntity<Materiel> updateSalle(@RequestBody Salle salle, BindingResult br) {
		ResponseEntity<Materiel> response = null;
		if (salle.getCode() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Materiel> opt = materielRepository.findById(salle.getCode());
		if (opt.isPresent()) {
			Materiel materielEnBase = opt.get();
			materielEnBase.setCout(salle.getCout());
			materielRepository.save(materielEnBase);
			response = new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return response;
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable(name = "code") Long code) {
		Optional<Materiel> opt = materielRepository.findById(code);
		if (opt.isPresent()) {
			materielRepository.deleteById(code);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Materiel>> findAll() {
		return new ResponseEntity<List<Materiel>>(materielRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)
	public ResponseEntity<Materiel> findByCode(@PathVariable(name = "code") Long code) {
		Optional<Materiel> opt = materielRepository.findByCode(code);
		if (opt.isPresent()) {
			return new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/cout/{cout}", method = RequestMethod.GET)
	public ResponseEntity<Materiel> findBycout(@PathVariable(name = "cout") Integer cout) {
		Optional<Materiel> opt = materielRepository.findByCout(cout);
		if (opt.isPresent()) {
			return new ResponseEntity<Materiel>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
