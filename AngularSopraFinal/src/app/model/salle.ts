import {Module} from './module';
import {Materiel} from './materiel';

export class Salle extends Materiel {

  constructor(private _nbDePersonne?, private _modules?) {
    super();
  }

  public get nbDePersonne(): number {
    return this._nbDePersonne
  }
  public set nbDePersonne(_nbDePersonne: number) {
    this._nbDePersonne = _nbDePersonne;
  }

  public get modules(): Array<Module> {
    return this._modules;
  }
  public set modules(_modules: Array<Module>) {
    this._modules = _modules;
  }
}