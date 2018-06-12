import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Module} from '../model/module';
import {Salle} from '../model/salle';
import {Formateur} from '../model/formateur';
import {Matiere} from '../model/matiere';

@Injectable()
export class ModuleService {

  url: string = 'http://localhost:8080/factory/rest/module';

  constructor(private http: HttpClient) {}

  public list(): Observable<Module[]> {
    return this.http.get<Module[]>(this.url);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public findById(id: number): Observable<Module> {
    return this.http.get<Module>(`${this.url}/${id}`);
  }

  public findBySalle(s: Salle): Observable<Module> {
    return this.http.get<Module>(`${this.url}/salle/${s}`);
  }

  public findByFormateur(f: Formateur): Observable<Module> {
    return this.http.get<Module>(`${this.url}/formateur/${f}`);
  }

  public findByMatiere(m: Matiere): Observable<Module> {
    return this.http.get<Module>(`${this.url}/matiere/${m}`);
  }

  public findByDateDebut(d: Date): Observable<Module> {
    return this.http.get<Module>(`${this.url}/debut/${d}`);
  }

  public findByDateFin(d: Date): Observable<Module> {
    return this.http.get<Module>(`${this.url}/fin/${d}`);
  }
}
