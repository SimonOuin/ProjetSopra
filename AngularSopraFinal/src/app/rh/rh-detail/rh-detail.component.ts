import {Component, OnInit} from '@angular/core';
import {RessourceHumaineService} from '../../service/ressource-humaine.service';
import {Formateur} from '../../model/formateur';
import {ActivatedRoute, Router} from '@angular/router';
import {RessourceHumaine} from '../../model/ressourceHumaine';

@Component({
  selector: 'app-rh-detail',
  templateUrl: './rh-detail.component.html',
  styleUrls: ['./rh-detail.component.css']
})
export class RhDetailComponent implements OnInit {

  private formateur: Formateur = new Formateur();

  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
  this.route.params.subscribe(params => {
      let numero = params.id;
      if (!!numero) {
        this.ressourceHumaineService.findByIdFormateur(params.id).subscribe(result => {
          this.formateur = result;
          console.log(this.formateur);
        });
      }

    });
  }

  public save() {
     if (!!this.formateur.id) {
      this.ressourceHumaineService.saveFormateur(this.formateur).subscribe(result => {
        this.home();
      });
    } else {
      this.ressourceHumaineService.createFormateur(this.formateur).subscribe(result => {
        this.home();
      });
    }
  }

  public home() {
    this.router.navigate(['/']);
  }

  public reset() {
    this.home();
  }

}
