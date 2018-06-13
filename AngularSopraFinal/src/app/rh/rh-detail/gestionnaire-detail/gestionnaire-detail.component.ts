import { Gestionnaire } from '../../../model/gestionnaire';
import { RessourceHumaineService } from '../../../service/ressource-humaine.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-gestionnaire-detail',
  templateUrl: './gestionnaire-detail.component.html',
  styleUrls: ['./gestionnaire-detail.component.css']
})
export class GestionnaireDetailComponent implements OnInit {

 private gestionnaire: Gestionnaire = new Gestionnaire();

  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      let numero = params.id;
      if (!!numero) {
        this.ressourceHumaineService.findByIdGestionnaire(params.id).subscribe(result => {
          this.gestionnaire = result;
          console.log(this.gestionnaire);
        });
      }

    });
  }

  public save() {
    if (!!this.gestionnaire.id) {
      this.ressourceHumaineService.saveGestionnaire(this.gestionnaire).subscribe(result => {
        this.home();
      });
    } else {
      this.ressourceHumaineService.createGestionnaire(this.gestionnaire).subscribe(result => {
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
