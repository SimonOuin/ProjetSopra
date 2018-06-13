import {Component, OnInit} from '@angular/core';
import {RessourceHumaine} from '../model/ressourceHumaine';
import {RessourceHumaineService} from '../service/ressource-humaine.service';

@Component({
  selector: 'app-rh',
  templateUrl: './rh.component.html',
  styleUrls: ['./rh.component.css']
})
export class RhComponent implements OnInit {

  liste: RessourceHumaine[];

  constructor(private ressourceHumaineService: RessourceHumaineService) {}

  ngOnInit() {
    this.list();
  }

  public list() {
    this.ressourceHumaineService.list().subscribe(result => {this.liste = result; console.log(result); }, error => {console.log(error); });
  }

}
