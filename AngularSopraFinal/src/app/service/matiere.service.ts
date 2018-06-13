import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Matiere} from '../model/matiere';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class MatiereService {

  url: string = 'http://localhost:8080/factory/rest/matiere';

  constructor(private http: HttpClient) {}

  public list(): Observable<Matiere[]> {
    return this.http.get<Matiere[]>(this.url);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public findById(id: number): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/${id}`);
  }

  public findByTitre(titre: string): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/titre/${titre}`);
  }

  public findByDuree(dureeProg: number): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/duree/${dureeProg}`);
  }

  public findByObjectif(objectif: string): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/objectif/${objectif}`);
  }

  public findByPrerequis(prerequis: string): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/prerequis/${prerequis}`);
  }

  public findByContenu(contenu: string): Observable<Matiere> {
    return this.http.get<Matiere>(`${this.url}/contenu/${contenu}`);
  }

  public saveMatiere(m: Matiere): Observable<Matiere> {
    return this.http.put<Matiere>(`${this.url}/matiere`, m);
  }

  public createMatiere(m: Matiere): Observable<any> {
    return this.http.post<any>(`${this.url}/matiere`, m);
  }
}
