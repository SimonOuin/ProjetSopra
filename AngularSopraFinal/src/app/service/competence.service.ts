import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {Competence} from '../model/competence';

@Injectable()
export class CompetenceService {

  url: string = 'http://localhost:8080/factory/rest/competence';

  constructor(private http: HttpClient) {}

  public list(): Observable<Competence[]> {
    return this.http.get<Competence[]>(this.url);
  }

  public delete(key: number): Observable<any> {
    return this.http.delete(`${this.url}/${key}`);
  }

  public findByNiveau(niveau: number): Observable<Competence> {
    return this.http.get<Competence>(`${this.url}/niveau/${niveau}`);
  }

   public saveCompetence(c: Competence): Observable<Competence> {
    return this.http.put<Competence>(`${this.url}/`, c);
  }
  
  public createCompetence(c: Competence): Observable<any> {
    return this.http.post<any>(`${this.url}`, c);
  }

}
