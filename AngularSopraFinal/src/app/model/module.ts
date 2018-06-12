import {Salle} from './salle';
import {Formateur} from './formateur';
import {Matiere} from './matiere';
import {VideoProjecteur} from './videoProjecteur';
import {Formation} from './formation';


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

  public get salle(): Salle {
    return this._salle
  }
  public set salle(_salle: Salle) {
    this._salle = _salle;
  }

  public get formateur(): Formateur {
    return this._formateur
  }
  public set formateur(_formateur: Formateur) {
    this._formateur = _formateur;
  }

  public get matiere(): Matiere {
    return this._matiere
  }
  public set matiere(_matiere: Matiere) {
    this._matiere = _matiere;
  }

  public get videoProjecteur(): VideoProjecteur {
    return this._videoProjecteur
  }
  public set videoProjecteur(_videoProjecteur: VideoProjecteur) {
    this._videoProjecteur = _videoProjecteur;
  }

  public get dateDebut(): Date {
    return this._dateDebut
  }
  public set dateDebut(_dateDebut: Date) {
    this._dateDebut = _dateDebut;
  }

  public get formation(): Formation {
    return this._formation
  }
  public set formation(_formation: Formation) {
    this._formation = _formation;
  }
}