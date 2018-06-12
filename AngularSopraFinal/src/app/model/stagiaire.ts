export class Stagiaire {

  constructor(private _ordinateur?, private _formation?) {
  }

  public get ordinateur(): object {
    return this._ordinateur
  }
  public set ordinateur(_ordinateur: object) {
    this._ordinateur = _ordinateur;
  }

  public get formation(): object {
    return this._formation
  }
  public set formation(_formation: object) {
    this._formation = _formation;
  }
}