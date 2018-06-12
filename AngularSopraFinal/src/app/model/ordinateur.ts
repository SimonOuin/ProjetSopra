import {Materiel} from './materiel';

export class Ordinateur extends Materiel {

  constructor(private _processeur?, private _ram?, private _disqueDur?, private _annee?) {
    super();
  }

  public get processeur(): string {
    return this._processeur
  }
  public set processeur(_processeur: string) {
    this._processeur = _processeur;
  }

  public get ram(): number {
    return this._ram
  }
  public set ram(_ram: number) {
    this._ram = _ram;
  }

  public get disqueDur(): number {
    return this._disqueDur
  }
  public set disqueDur(_disqueDur: number) {
    this._disqueDur = _disqueDur;
  }

  public get annee(): number {
    return this._annee
  }
  public set annee(_annee: number) {
    this._annee = _annee;
  }
}