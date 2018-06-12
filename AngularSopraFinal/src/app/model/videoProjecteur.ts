import {Module} from './module';
import {Materiel} from './materiel';

export class VideoProjecteur extends Materiel {
  
  constructor(private _module?) {
    super();
  }

  public get module(): Module {
    return this._module
  }
  public set module(_module: Module) {
    this._module = _module;
  }
}