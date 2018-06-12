import {Module} from './module';

export class VideoProjecteur {
  constructor(private _module?) {
  }

  public get module(): Module {
    return this._module
  }
  public set module(_module: Module) {
    this._module = _module;
  }
}