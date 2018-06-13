import {Ordinateur} from './ordinateur';
import {Formation} from './formation';
import {RessourceHumaine} from './ressourceHumaine';

export class Stagiaire  extends RessourceHumaine{

  constructor(private _ordinateur?, private _formation?) {
    super('stagiaire');
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