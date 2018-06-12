import {Formation} from './formation';

export class Gestionaire {
  constructor(private _formations?) {
  }

  public get fromations(): Array<Formation> {
    return this._formations
  }
  public set formations(_formations: Array<Formation>) {
    this._formations = _formations;
  }
}