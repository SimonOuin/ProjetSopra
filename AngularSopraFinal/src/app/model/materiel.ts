export class Materiel {
  constructor(private _code?, private _cout?) {
  }

  public get code(): number {
    return this._code
  }
  public set code(_code: number) {
    this._code = _code;
  }

  public get cout(): number {
    return this._cout
  }
  public set cout(_cout: number) {
    this._cout = _cout;
  }
}