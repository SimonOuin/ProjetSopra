import {Adresse} from './adresse';

export class RessourceHumaine {

  constructor(private _id?, private _nom?, private _prenom?, private _tel?, private _email?,
    private _login?, private _mdp?, private _adresse?) {
  }

  public get id(): number {
    return this._id
  }
  public set id(_id: number) {
    this._id = _id;
  }

  public get nom(): string {
    return this._nom
  }
  public set nom(_nom: string) {
    this._nom = _nom;
  }

  public get prenom(): string {
    return this._prenom
  }
  public set prenom(_prenom: string) {
    this._prenom = _prenom;
  }

  public get tel(): number {
    return this._tel
  }
  public set tel(_tel: number) {
    this._tel = _tel;
  }

  public get email(): string {
    return this._email
  }
  public set email(_email: string) {
    this._email = _email;
  }

  public get login(): string {
    return this._login
  }
  public set login(_login: string) {
    this._login = _login;
  }

  public get mdp(): string {
    return this._mdp
  }
  public set mdp(_mdp: string) {
    this._mdp = _mdp;
  }

  public get adresse(): Adresse {
    return this._adresse
  }
  public set adresse(_adresse: Adresse) {
    this._adresse = _adresse;
  }
}