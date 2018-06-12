import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {Materiel} from '../model/materiel';
import {Ordinateur} from '../model/ordinateur';
import {VideoProjecteur} from '../model/videoprojecteur';
import {Salle} from '../model/salle';

@Injectable()
export class MaterielService {

  url: string = 'http://localhost:8080/factory/rest/materiel';

  constructor(private http: HttpClient) {}

  public list(): Observable<Materiel[]> {
    return this.http.get<Materiel[]>(this.url);
  }

  public delete(code: number): Observable<any> {
    return this.http.delete(`${this.url}/${code}`);
  }

  public findByCode(code: number): Observable<Materiel> {
    return this.http.get<Materiel>(`${this.url}/${code}`);
  }

  public findByCout(cout: number): Observable<Materiel> {
    return this.http.get<Materiel>(`${this.url}/cout/${cout}`);
  }

  public saveOrdinateur(m: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/ordinateur`, m);
  }

  public saveVideoProjecteur(m: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/videoprojecteur`, m);
  }

  public saveSalle(m: Materiel): Observable<Materiel> {
    return this.http.put<Materiel>(`${this.url}/salle`, m);
  }

  public createOrdinateur(o: Ordinateur): Observable<any> {
    return this.http.post<any>(`${this.url}/ordinateur`, o);
  }

  public createVideoProjecteur(v: VideoProjecteur): Observable<any> {
    return this.http.post<any>(`${this.url}/videoprojecteur`, v);
  }

  public createSalle(s: Salle): Observable<any> {
    return this.http.post<any>(`${this.url}/salle`, s);
  }
}
