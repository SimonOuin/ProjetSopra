package com.example.demo.restController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.jsonview.JsonViews;
import com.example.demo.model.Matiere;
import com.example.demo.model.Module;
import com.example.demo.repository.MatiereRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/matiere")
public class MatiereRestController {

	@Autowired
	private MatiereRepository matiereRepository;

	@RequestMapping(path = { "/matiere", "/matiere/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createMatiere(@RequestBody Matiere matiere, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (matiere.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			matiereRepository.save(matiere);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/matiere/{id}").buildAndExpand(matiere.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/matiere", "/matiere/" }, method = RequestMethod.PUT)
	public ResponseEntity<Matiere> updateMatiere(@RequestBody Matiere matiere, BindingResult br) {
		ResponseEntity<Matiere> response = null;
		if (matiere.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Matiere> opt = matiereRepository.findById(matiere.getId());
		if (opt.isPresent()) {
			Matiere matiereEnBase = opt.get();
			matiereEnBase.setTitre(matiere.getTitre());
			matiereEnBase.setDureeProg(matiere.getDureeProg());
			matiereEnBase.setObjectif(matiere.getObjectif());
			matiereEnBase.setPrerequis(matiere.getPrerequis());
			matiereEnBase.setContenu(matiere.getContenu());

			matiereRepository.save(matiereEnBase);
			response = new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);

		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteMatiere(@PathVariable(name = "id") Long id){
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			matiereRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<Matiere>> findAll() {
		return new ResponseEntity<List<Matiere>>(matiereRepository.findAll(), HttpStatus.OK);
	}

	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findById(@PathVariable(name = "id") Long id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/titre/{titre}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findByTitre(@PathVariable(name = "titre") String titre) {
		Optional<Matiere> opt = matiereRepository.findByTitre(titre);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/duree/{dureeProg}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findByDureeProg(@PathVariable(name = "dureeProg") Integer dureeProg) {
		Optional<Matiere> opt = matiereRepository.findByDureeProg(dureeProg);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/objectif/{objectif}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findByObjectif(@PathVariable(name = "objectif") String objectif) {
		Optional<Matiere> opt = matiereRepository.findByObjectif(objectif);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/prerequis/{prerequis}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findByPrerequis(@PathVariable(name = "prerequis") String prerequis) {
		Optional<Matiere> opt = matiereRepository.findByPrerequis(prerequis);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/contenu/{contenu}", method = RequestMethod.GET)
	public ResponseEntity<Matiere> findByContenu(@PathVariable(name = "contenu") String contenu) {
		Optional<Matiere> opt = matiereRepository.findByContenu(contenu);
		if (opt.isPresent()) {
			return new ResponseEntity<Matiere>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
