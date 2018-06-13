import {Materiel} from '../model/materiel';
import {MaterielService} from '../service/materiel.service';
import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-technicien',
  templateUrl: './technicien.component.html',
  styleUrls: ['./technicien.component.css']
})
export class TechnicienComponent implements OnInit {

  liste: Materiel[];

  constructor(private materielService: MaterielService) {}

  ngOnInit() {
    this.list();
  }

  public list() {
    this.materielService.list().subscribe(result => {this.liste = result; console.log(result);}, error => {console.log(error);});
  }

}
