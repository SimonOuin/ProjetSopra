import { Matiere } from '../model/matiere';
import { MatiereService } from '../service/matiere.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-matiere',
  templateUrl: './matiere.component.html',
  styleUrls: ['./matiere.component.css']
})
export class MatiereComponent implements OnInit {
  
  liste: Matiere[];

  constructor(private matiereService: MatiereService) { }

  ngOnInit() {
    this.list();
  }

  public list(){
    this.matiereService.list().subscribe(result => {this.liste = result; console.log(result);}, error => {console.log(error);});
  }
  
  public delete(id: number) {
    this.matiereService.delete(id).subscribe(result => {this.list()}, error => {console.log(error);});
  }
}
