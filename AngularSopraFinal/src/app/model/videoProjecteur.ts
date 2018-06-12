export class VideoProjecteur {
  constructor(private _module?) {
  }

  public get module(): object {
    return this._module
  }
  public set module(_module: object) {
    this._module = _module;
  }
}