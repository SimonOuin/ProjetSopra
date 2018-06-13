import {Adresse} from '../model/adresse';
import {Formateur} from '../model/formateur';
import {Gestionnaire} from '../model/gestionnaire';
import {RessourceHumaine} from '../model/ressourceHumaine';
import {Stagiaire} from '../model/stagiaire';
import {Technicien} from '../model/technicien';
import {RessourceHumaineService} from '../service/ressource-humaine.service';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-inscriptionformateur',
  templateUrl: './inscriptionformateur.component.html',
  styleUrls: ['./inscriptionformateur.component.css']
})
export class InscriptionformateurComponent implements OnInit {
  [x: string]: any;
  private ressourceHumaine: RessourceHumaine | any = {};
  private formateur: Formateur | any = {};
  private stagiaire: Stagiaire | any = {};
  private technicien: Technicien | any = {};
  private gestionnaire: Gestionnaire | any = {};
  private adresse: Adresse | any = {};

  constructor() {}

  ngOnInit() {
  }

  home() {
    this.router.navigate(['/']);
  }

  public createFormateur() {
     console.log('create Formateur');
    this.ressourceHumaineService.createFormateur(this.formateur).subscribe(result => {this.home()});
  }
}
