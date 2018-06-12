import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import {RessourceHumaine} from '../model/ressourceHumaine';
import {Gestionnaire} from '../model/gestionnaire';
import {Technicien} from '../model/technicien';
import {Formateur} from '../model/formateur';
import {Stagiaire} from '../model/stagiaire';
import {Adresse} from '../model/adresse';

@Injectable()
export class RessourceHumaineService {

  url: string = 'http://localhost:8080/factory/rest/rh';

  constructor(private http: HttpClient) {}

  public list(): Observable<RessourceHumaine[]> {
    return this.http.get<RessourceHumaine[]>(this.url);
  }

  public delete(id: number): Observable<any> {
    return this.http.delete(`${this.url}/${id}`);
  }

  public findById(id: number): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/${id}`);
  }

  public findByNom(nom: string): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/nom/${nom}`);
  }

  public findByPrenom(prenom: number): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/prenom/${prenom}`);
  }

  public findByAdresse(adresse: Adresse): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/adresse/${adresse}`);
  }

  public findByTel(tel: number): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/tel/${tel}`);
  }

  public findByEmail(email: string): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/email/${email}`);
  }

  public findByLogin(login: string): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/login/${login}`);
  }

  public findByMdp(mdp: string): Observable<RessourceHumaine> {
    return this.http.get<RessourceHumaine>(`${this.url}/mdp/${mdp}`);
  }

  public saveGestionnaire(rh: RessourceHumaine): Observable<RessourceHumaine> {
    return this.http.put<RessourceHumaine>(`${this.url}/gestionnaire`, rh);
  }

  public saveTechnicien(rh: RessourceHumaine): Observable<RessourceHumaine> {
    return this.http.put<RessourceHumaine>(`${this.url}/technicien`, rh);
  }

  public saveStagiaire(rh: RessourceHumaine): Observable<RessourceHumaine> {
    return this.http.put<RessourceHumaine>(`${this.url}/stagiaire`, rh);
  }

  public saveFormateur(rh: RessourceHumaine): Observable<RessourceHumaine> {
    return this.http.put<RessourceHumaine>(`${this.url}/formateur`, rh);
  }

  public createGestionnaire(g: Gestionnaire): Observable<any> {
    return this.http.post<any>(`${this.url}/gestionnaire`, g);
  }

  public createTechnicien(t: Technicien): Observable<any> {
    return this.http.post<any>(`${this.url}/technicien`, t);
  }

  public createFormateur(f: Formateur): Observable<any> {
    return this.http.post<any>(`${this.url}/formateur`, f);
  }

  public createStagiaire(s: Stagiaire): Observable<any> {
    return this.http.post<any>(`${this.url}/ordinateur`, s);
  }
}
