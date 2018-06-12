import {Formation} from './formation';
import {RessourceHumaine} from './ressourceHumaine';

export class Gestionnaire extends RessourceHumaine{
  constructor(private _formations?) {
    super();
  }

  public get fromations(): Array<Formation> {
    return this._formations
  }
  public set formations(_formations: Array<Formation>) {
    this._formations = _formations;
  }
}