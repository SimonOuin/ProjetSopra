import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Formation} from '../model/formation';
import {Stagiaire} from '../model/stagiaire';
import {Module} from '../model/module';

@Injectable()
export class FormationService {

  url: string = 'http://localhost:8080/factory/rest/formation';

  constructor(private http: HttpClient) {}

  public list(): Observable<Formation[]> {
    return this.http.get<Formation[]>(this.url);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public findById(id: number): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/${id}`);
  }

  public findByStagiaire(s: Stagiaire): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/stagiaire/${s}`);
  }

  public findByModule(m: Module): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/module/${m}`);
  }

  public findByDateDebut(d: Date): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/debut/${d}`);
  }

  public findByDateFin(f: Date): Observable<Formation> {
    return this.http.get<Formation>(`${this.url}/fin/${f}`);
  }

  public saveFormation(f: Formation): Observable<Formation> {
    return this.http.put<Formation>(`${this.url}`, f);
  }

  public createFormation(f: Formation): Observable<any> {
    return this.http.post<any>(`${this.url}`, f);
  }
}
