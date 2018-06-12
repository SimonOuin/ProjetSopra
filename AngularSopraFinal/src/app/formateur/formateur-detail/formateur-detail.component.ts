import {Component, OnInit} from '@angular/core';
import {RessourceHumaineService} from '../../service/ressource-humaine.service';
import {Formateur} from '../../model/formateur';
import {ActivatedRoute, Router} from '@angular/router';
import {RessourceHumaine} from '../../model/ressourceHumaine';

@Component({
  selector: 'app-formateur-detail',
  templateUrl: './formateur-detail.component.html',
  styleUrls: ['./formateur-detail.component.css']
})
export class FormateurDetailComponent implements OnInit {

  private formateur: RessourceHumaine;

  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
  this.route.params.subscribe(params => {
      let numero = params.id;
      if (!!numero) {
        this.ressourceHumaineService.findById(params.id).subscribe(result => {
          this.formateur = result;
          console.log(this.formateur);
        });
      }

    });
  }

  public save() {
    this.ressourceHumaineService.saveFormateur(this.formateur).subscribe(result => {
      this.home();
    });
  }

  public home() {
    this.router.navigate(['/']);
  }

  public reset() {
    this.home();
  }

}
