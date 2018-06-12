import {Module} from './module';
import {Competence} from './competence';

export class Formateur {

  constructor(private _modules?, private _competence?) {
  }

  public get modules(): Array<Module> {
    return this._modules;
  }
  public set modules(_modules: Array<Module>) {
    this._modules = _modules;
  }

  public get competence(): Array<Competence> {
    return this._competence;
  }
  public set competence(_competence: Array<Competence>) {
    this._competence = _competence;
  }
}