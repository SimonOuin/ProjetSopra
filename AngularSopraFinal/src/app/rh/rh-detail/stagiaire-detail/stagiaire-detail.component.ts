import {Component, OnInit} from '@angular/core';
import {Stagiaire} from '../../../model/stagiaire';
import {RessourceHumaineService} from '../../../service/ressource-humaine.service';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-stagiaire-detail',
  templateUrl: './stagiaire-detail.component.html',
  styleUrls: ['./stagiaire-detail.component.css']
})
export class StagiaireDetailComponent implements OnInit {

  private stagiaire: Stagiaire = new Stagiaire();

  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      let numero = params.id;
      if (!!numero) {
        this.ressourceHumaineService.findByIdStagiaire(params.id).subscribe(result => {
          this.stagiaire = result;
          console.log(this.stagiaire);
        });
      }

    });
  }

  public save() {
    if (!!this.stagiaire.id) {
      this.ressourceHumaineService.saveStagiaire(this.stagiaire).subscribe(result => {
        this.home();
      });
    } else {
      this.ressourceHumaineService.createStagiaire(this.stagiaire).subscribe(result => {
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



