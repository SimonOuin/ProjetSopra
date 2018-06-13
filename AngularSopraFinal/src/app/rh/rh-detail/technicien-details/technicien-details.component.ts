import { Technicien } from '../../../model/technicien';
import { RessourceHumaineService } from '../../../service/ressource-humaine.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-technicien-detail',
  templateUrl: './technicien-details.component.html',
  styleUrls: ['./technicien-details.component.css']
})
export class TechnicienDetailsComponent implements OnInit {
  
private technicien: Technicien = new Technicien();

  constructor(private router: Router, private route: ActivatedRoute, private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {
      let numero = params.id;
      if (!!numero) {
        this.ressourceHumaineService.findByIdTechnicien(params.id).subscribe(result => {
          this.technicien = result;
          console.log(this.technicien);
        });
      }

    });
  }

  public save() {
    if (!!this.technicien.id) {
      this.ressourceHumaineService.saveTechnicien(this.technicien).subscribe(result => {
        this.home();
      });
    } else {
      this.ressourceHumaineService.createTechnicien(this.technicien).subscribe(result => {
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
