import { Adresse } from '../model/adresse';
import {Formateur} from '../model/formateur';
import {Gestionnaire} from '../model/gestionnaire';
import {RessourceHumaine} from '../model/ressourceHumaine';
import {Stagiaire} from '../model/stagiaire';
import {Technicien} from '../model/technicien';
import {RessourceHumaineService} from '../service/ressource-humaine.service';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {FormGroup, FormControl, Validators} from '@angular/forms';


@Component({
  selector: 'app-inscriptionStagiaire',
  templateUrl: './inscriptionStagiaire.component.html',
  styleUrls: ['./inscriptionStagiaire.component.css']

})
export class InscriptionStagiaireComponent implements OnInit {
  [x: string]: any;
  private ressourceHumaine: RessourceHumaine | any = {};
  private formateur: Formateur | any = {};
  private stagiaire: Stagiaire | any = {};
  private technicien: Technicien | any = {};
  private gestionnaire: Gestionnaire | any = {};
  private adresse : Adresse | any = {};
  


  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
  }
  
  home(){
    this.router.navigate(['/']);
  }

  public createFormateur() {
    if (!!this.formateur.id) {
      this.ressourceHumaineService.saveFormateur(this.formateur).subscribe(result => {this.router.navigate(['/formateur'])});
    } else {
      this.ressourceHumaineService.createFormateur(this.formateur).subscribe(result => {this.home()});
    }
  }

  public createStagiaire() {
    console.log('create');
      this.ressourceHumaineService.createStagiaire(this.stagiaire).subscribe(result => {this.home()});
  }

  public createTechnicien() {
    if (!!this.technicien.id) {
      this.ressourceHumaineService.saveTechnicien(this.technicien).subscribe(result => {this.router.navigate(['/technicien'])});
    } else {
      this.ressourceHumaineService.createTechnicien(this.technicien).subscribe(result => {this.home()});
    }
  }

  public createGestionnaire() {
    if (!!this.gestionnaire.id) {
      this.ressourceHumaineService.saveGestionnaire(this.gestionnaire).subscribe(result => {this.router.navigate(['/gestionnaire'])});
    } else {
      this.ressourceHumaineService.createGestionnaire(this.gestionnaire).subscribe(result => {this.home()});
    }
  }
}
