import {Stagiaire} from './stagiaire';
import {Module} from './module';
import {Gestionaire} from './gestionaire';

export class Formation {

  constructor(private _id?, private _stagiaires?, private _modules?, private _dateDebut?, private _dateFin?, private _gestionaire?) {
  }

  public get id(): number {
    return this._id;
  }
  public set id(_id: number) {
    this._id = _id;
  }

  public get stagiaires(): Array<Stagiaire> {
    return this._stagiaires;
  }
  public set stagiaires(_stagiaires: Array<Stagiaire>) {
    this._stagiaires = _stagiaires;
  }

  public get modules(): Array<Module> {
    return this._modules;
  }
  public set modules(_modules: Array<Module>) {
    this._modules = _modules;
  }

  public get dateDebut(): Date {
    return this._dateDebut;
  }
  public set dateDebut(_dateDebut: Date) {
    this._dateDebut = _dateDebut;
  }

  public get gestionaire(): object {
    return this._gestionaire;
  }
  public set gestionaire(_gestionaire: object) {
    this._gestionaire = _gestionaire;
  }
}