import {Adresse} from '../model/adresse';
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
  private adresse: Adresse | any = {};

  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
  }

  home() {
    this.router.navigate(['/dashboard']);
  }

  public createStagiaire() {
    console.log('create Stagiaire');
    console.log(this.stagiaire);
    this.ressourceHumaineService.createStagiaire(this.stagiaire).subscribe(result => {this.home()});
  }


}
