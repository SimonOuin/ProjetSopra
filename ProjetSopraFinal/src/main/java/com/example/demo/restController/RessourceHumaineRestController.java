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
import com.example.demo.model.Adresse;
import com.example.demo.model.Formateur;
import com.example.demo.model.Gestionnaire;
import com.example.demo.model.RessourceHumaine;
import com.example.demo.model.Stagiaire;
import com.example.demo.model.Technicien;
import com.example.demo.repository.RessourceHumaineRepository;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/rh")
@CrossOrigin(origins = "*")
public class RessourceHumaineRestController {

	@Autowired
	private RessourceHumaineRepository ressourceHumaineRepository;

	@RequestMapping(path = { "/gestionnaire", "/gestionnaire/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createGestionnaire(@RequestBody Gestionnaire gestionnaire, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (gestionnaire.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(gestionnaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(gestionnaire.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/technicien", "/technicien/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createTechnicien(@RequestBody Technicien technicien, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (technicien.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(technicien);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(technicien.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/stagiaire", "/stagiaire/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createStagiaire(@RequestBody Stagiaire stagiaire, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (stagiaire.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(stagiaire);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(stagiaire.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = { "/formateur", "/formateur/" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createFormateur(@RequestBody Formateur formateur, BindingResult br,
			UriComponentsBuilder ucb) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		if (formateur.getId() != null) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(formateur);
			HttpHeaders header = new HttpHeaders();
			header.setLocation(ucb.path("/rest/rh/{id}").buildAndExpand(formateur.getId()).toUri());
			response = new ResponseEntity<Void>(header, HttpStatus.OK);
		}

		return response;
	}
	
	@RequestMapping(path = { "/formateur", "/formateur/" }, method = RequestMethod.PUT)
	public ResponseEntity<RessourceHumaine> updateFormateur(@RequestBody Formateur formateur, BindingResult br) {
		ResponseEntity<RessourceHumaine> response = null;
		if (formateur.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(formateur.getId());
		if (opt.isPresent()) {
			RessourceHumaine personneEnBase=opt.get();
			personneEnBase.setAdresse(formateur.getAdresse());
			personneEnBase.setPrenom(formateur.getPrenom());
			personneEnBase.setNom(formateur.getNom());
			personneEnBase.setEmail(formateur.getEmail());
			personneEnBase.setTel(formateur.getTel());
			personneEnBase.setLogin(formateur.getLogin());
			personneEnBase.setMdp(formateur.getMdp());
			ressourceHumaineRepository.save(personneEnBase);
			response=  new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
			
		} else {
			response= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(path = { "/gestionnaire", "/gestionnaire/" }, method = RequestMethod.PUT)
	public ResponseEntity<RessourceHumaine> updateGestionnaire(@RequestBody Gestionnaire gestionnaire, BindingResult br) {
		ResponseEntity<RessourceHumaine> response = null;
		if (gestionnaire.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(gestionnaire.getId());
		if (opt.isPresent()) {
			RessourceHumaine personneEnBase=opt.get();
			personneEnBase.setAdresse(gestionnaire.getAdresse());
			personneEnBase.setPrenom(gestionnaire.getPrenom());
			personneEnBase.setNom(gestionnaire.getNom());
			personneEnBase.setEmail(gestionnaire.getEmail());
			personneEnBase.setTel(gestionnaire.getTel());
			personneEnBase.setLogin(gestionnaire.getLogin());
			personneEnBase.setMdp(gestionnaire.getMdp());
			ressourceHumaineRepository.save(personneEnBase);
			response=  new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
			
		} else {
			response= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(path = { "/technicien", "/technicien/" }, method = RequestMethod.PUT)
	public ResponseEntity<RessourceHumaine> updateTechnicien(@RequestBody Technicien technicien, BindingResult br) {
		ResponseEntity<RessourceHumaine> response = null;
		if (technicien.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(technicien.getId());
		if (opt.isPresent()) {
			RessourceHumaine personneEnBase=opt.get();
			personneEnBase.setAdresse(technicien.getAdresse());
			personneEnBase.setPrenom(technicien.getPrenom());
			personneEnBase.setNom(technicien.getNom());
			personneEnBase.setEmail(technicien.getEmail());
			personneEnBase.setTel(technicien.getTel());
			personneEnBase.setLogin(technicien.getLogin());
			personneEnBase.setMdp(technicien.getMdp());
			ressourceHumaineRepository.save(personneEnBase);
			response=  new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
			
		} else {
			response= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(path = { "/stagiaire", "/stagiaire/" }, method = RequestMethod.PUT)
	public ResponseEntity<RessourceHumaine> updateStagiaire(@RequestBody Stagiaire stagiaire, BindingResult br) {
		ResponseEntity<RessourceHumaine> response = null;
		if (stagiaire.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(stagiaire.getId());
		if (opt.isPresent()) {
			RessourceHumaine personneEnBase=opt.get();
			personneEnBase.setAdresse(stagiaire.getAdresse());
			personneEnBase.setPrenom(stagiaire.getPrenom());
			personneEnBase.setNom(stagiaire.getNom());
			personneEnBase.setEmail(stagiaire.getEmail());
			personneEnBase.setTel(stagiaire.getTel());
			personneEnBase.setLogin(stagiaire.getLogin());
			personneEnBase.setMdp(stagiaire.getMdp());
			ressourceHumaineRepository.save(personneEnBase);
			response=  new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
			
		} else {
			response= new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@RequestMapping(value="/{id}", method= RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRH(@PathVariable(name = "id") Long id){
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(id);
		if (opt.isPresent()) {
			ressourceHumaineRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(path = { "", "/" }, method = RequestMethod.GET)
	public ResponseEntity<List<RessourceHumaine>> findAll() {
		return new ResponseEntity<List<RessourceHumaine>>(ressourceHumaineRepository.findAll(), HttpStatus.OK);
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findById(@PathVariable(name = "id") Long id) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/nom/{nom}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByNom(@PathVariable(name = "nom") String nom) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByNom(nom);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/prenom/{prenom}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByPrenom(@PathVariable(name = "prenom") String prenom) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByPrenom(prenom);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/adresse/{adresse}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByAdresse(@PathVariable(name = "adresse") Adresse adresse) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByAdresse(adresse);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/tel/{tel}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByTel(@PathVariable(name = "tel") Integer tel) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByTel(tel);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByEmail(@PathVariable(name = "email") String email) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByEmail(email);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByLogin(@PathVariable(name = "login") String login) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByLogin(login);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@JsonView(JsonViews.Common.class)
	@RequestMapping(value = "/mdp/{mdp}", method = RequestMethod.GET)
	public ResponseEntity<RessourceHumaine> findByMdp(@PathVariable(name = "mdp") String mdp) {
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findByMdp(mdp);
		if (opt.isPresent()) {
			return new ResponseEntity<RessourceHumaine>(opt.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
}
