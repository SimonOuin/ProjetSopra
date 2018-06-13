import {Module} from './module';
import {Competence} from './competence';
import {RessourceHumaine} from './ressourceHumaine';

export class Formateur extends RessourceHumaine{

  constructor(private _modules?, private _competence?) {
    super('formateur');
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