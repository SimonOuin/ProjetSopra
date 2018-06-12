export class Matiere {

  constructor(private _id?, private _titre?, private _dureeProg?, private _objectif?, private _prerequis?, private _contenu?) {
  }

  public get id(): number {
    return this._id
  }
  public set id(_id: number) {
    this._id = _id;
  }

  public get titre(): string {
    return this._titre
  }
  public set titre(_titre: string) {
    this._titre = _titre;
  }

  public get dureeProg(): number {
    return this._dureeProg
  }
  public set dureeProg(_dureeProg: number) {
    this._dureeProg = _dureeProg;
  }

  public get objectif(): string {
    return this._objectif
  }
  public set objectif(_objectif: string) {
    this._objectif = _objectif;
  }

  public get prerequis(): string {
    return this._prerequis
  }
  public set prerequis(_prerequis: string) {
    this._prerequis = _prerequis;
  }

  public get contenu(): string {
    return this._contenu
  }
  public set contenu(_contenu: string) {
    this._contenu = _contenu;
  }
}