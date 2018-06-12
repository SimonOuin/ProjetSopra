import {Ordinateur} from './ordinateur';
import {Formation} from './formation';

export class Stagiaire {

  constructor(private _ordinateur?, private _formation?) {
  }

  public get ordinateur(): Ordinateur {
    return this._ordinateur
  }
  public set ordinateur(_ordinateur: Ordinateur) {
    this._ordinateur = _ordinateur;
  }

  public get formation(): Formation {
    return this._formation
  }
  public set formation(_formation: Formation) {
    this._formation = _formation;
  }
}