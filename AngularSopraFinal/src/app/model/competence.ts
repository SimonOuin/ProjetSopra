import {Niveau} from './niveau';

export class Competence {

  constructor(private _niveau?) {
  }

  public get niveau(): number {
    return this._niveau;
  }
  public set niveau(_niveau: number) {
    this._niveau = _niveau;
  }
}