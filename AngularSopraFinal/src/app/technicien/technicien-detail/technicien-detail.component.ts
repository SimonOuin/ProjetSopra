import { Materiel } from '../../model/materiel';
import { MaterielService } from '../../service/materiel.service';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-technicien-detail',
  templateUrl: './technicien-detail.component.html',
  styleUrls: ['./technicien-detail.component.css']
})
export class TechnicienDetailComponent implements OnInit {
  
  private materiel: Materiel | any= {};

  constructor(private router: Router, private route: ActivatedRoute, private materielService: MaterielService) { }

  ngOnInit() {
    this.route.params.subscribe(params => {let numero = params.code; if (!!numero) {this.materielService.findByCode(params.code).subscribe(result => {this.materiel= result});}});
  }

  public save(){
    if(this.materiel.code) {
      this.materielService.saveOrdinateur(this.materiel).subscribe(result => {this.router.navigate(['/technicien'])});
    } else {
      this.materielService.createOrdinateur(this.materiel).subscribe (result => {this.home()});
    }
  }
  
  public reset() {
    this.home();

  }

  private home() {
    this.router.navigate(['/technicien']);
  }
}
