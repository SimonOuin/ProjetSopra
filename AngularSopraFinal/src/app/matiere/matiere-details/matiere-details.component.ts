import {Matiere} from '../../model/matiere';
import {MatiereService} from '../../service/matiere.service';
import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-matiere-details',
  templateUrl: './matiere-details.component.html',
  styleUrls: ['./matiere-details.component.css']
})
export class MatiereDetailsComponent implements OnInit {
  private matiere: Matiere | any = {};

  constructor(private router: Router, private route: ActivatedRoute, private matiereService: MatiereService) {}

  ngOnInit() {
    this.route.params.subscribe(params => {let numero = params.id; if (!!numero) {this.matiereService.findById(params.id).subscribe(result => {this.matiere = result});} });
  }

  public save() {
    if (this.matiere.id) {
      this.matiereService.saveMatiere(this.matiere).subscribe(result => {this.router.navigate(['/matiere'])});
    } else {
      this.matiereService.createMatiere(this.matiere).subscribe(result => {this.home()});
    }
  }

  public reset() {
    this.home();

  }

  private home() {
    this.router.navigate(['/matiere']);
  }
}
