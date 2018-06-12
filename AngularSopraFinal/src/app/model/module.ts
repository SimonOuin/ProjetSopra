
export class Module {

  constructor(private _id?, private _salle?, private _formateur?, private _matiere?, private _videoProjecteur?,
    private _dateDebut?, private _formation?) {
  }

  public get id(): number {
    return this._id
  }
  public set id(_id: number) {
    this._id = _id;
  }

  public get salle(): object {
    return this._salle
  }
  public set salle(_salle: object) {
    this._salle = _salle;
  }

  public get formateur(): object {
    return this._formateur
  }
  public set formateur(_formateur: object) {
    this._formateur = _formateur;
  }

  public get matiere(): object {
    return this._matiere
  }
  public set matiere(_matiere: object) {
    this._matiere = _matiere;
  }

  public get videoProjecteur(): object {
    return this._videoProjecteur
  }
  public set videoProjecteur(_videoProjecteur: object) {
    this._videoProjecteur = _videoProjecteur;
  }

  public get dateDebut(): Date {
    return this._dateDebut
  }
  public set dateDebut(_dateDebut: Date) {
    this._dateDebut = _dateDebut;
  }

  public get formation(): object {
    return this._formation
  }
  public set formation(_formation: object) {
    this._formation = _formation;
  }
}