import { Materiel } from '../../../model/materiel';
import { MaterielService } from '../../../service/materiel.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-techniciensalle-details',
  templateUrl: './techniciensalle-details.component.html',
  styleUrls: ['./techniciensalle-details.component.css']
})
export class TechniciensalleDetailsComponent implements OnInit {
 private materiel: Materiel | any= {};

  constructor(private router: Router, private route: ActivatedRoute, private materielService: MaterielService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {let numero = params.code; if (!!numero) {this.materielService.findByCode(params.code).subscribe(result => {this.materiel= result});}});
  }

  public save(){
    if(this.materiel.code) {
      this.materielService.saveSalle(this.materiel).subscribe(result => {this.router.navigate(['/technicien'])});
    } else {
      this.materielService.createSalle(this.materiel).subscribe (result => {this.home()});
    }
  }
  
  public reset() {
    this.home();

  }

  private home() {
    this.router.navigate(['/technicien']);
  }
}
