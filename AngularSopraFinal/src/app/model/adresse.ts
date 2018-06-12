export class Adresse {

  constructor(private _numero?, private _rue?, private _cp?, private _ville?, private _pays?) {
  }

  public get numero(): number {
    return this._numero;
  }
  public set numero(_numero: number) {
    this._numero = _numero;
  }

  public get rue(): string {
    return this._rue;
  }
  public set rue(_rue: string) {
    this._rue = _rue;
  }

  public get cp(): number {
    return this._cp;
  }
  public set cp(_cp: number) {
    this._cp = _cp;
  }

  public get ville(): string {
    return this._ville;
  }
  public set ville(_ville: string) {
    this._ville = _ville;
  }

  public get pays(): string {
    return this._pays;
  }
  public set pays(_pays: string) {
    this._pays = _pays;
  }

}
