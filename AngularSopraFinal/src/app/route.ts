import {DashboardComponent} from './dashboard/dashboard.component';
import { DemoComponent } from './demo/component';
import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import { MatiereDetailsComponent } from './matiere/matiere-details/matiere-details.component';
import { MatiereComponent } from './matiere/matiere.component';
import {GestionnaireDetailComponent} from './rh/rh-detail/gestionnaire-detail/gestionnaire-detail.component';
import {RhDetailComponent} from './rh/rh-detail/rh-detail.component';
import {StagiaireDetailComponent} from './rh/rh-detail/stagiaire-detail/stagiaire-detail.component';
import {TechnicienDetailsComponent} from './rh/rh-detail/technicien-details/technicien-details.component';
import {RhComponent} from './rh/rh.component';
import { TechnicienDetailComponent } from './technicien/technicien-detail/technicien-detail.component';
import { TechniciensalleDetailsComponent } from './technicien/technicien-detail/techniciensalle-details/techniciensalle-details.component';
import { TechnicienvideoDetailComponent } from './technicien/technicien-detail/technicienvideo-detail/technicienvideo-detail.component';
import { TechnicienComponent } from './technicien/technicien.component';

export const routes: Routes = [
  {path: 'rh', component: RhComponent},
  {path: 'rhdetail/:id', component: RhDetailComponent},
  {path: 'rhdetail', component: RhDetailComponent},
  {path: 'stagiairedetail/:id', component: StagiaireDetailComponent},
  {path: 'stagiairedetail', component: StagiaireDetailComponent},
  {path: 'gestionnairedetail/:id', component: GestionnaireDetailComponent},
  {path: 'gestionnairedetail', component: GestionnaireDetailComponent},
  {path: 'techniciendetail/:id', component: TechnicienDetailsComponent},
  {path: 'techniciendetail', component: TechnicienDetailsComponent},
  {path: 'dashboard', component: DashboardComponent},
  {path: 'technicien/creer', component: TechnicienDetailComponent},
  {path: 'technicien/creervideo', component: TechnicienvideoDetailComponent},
  {path: 'technicien/creersalle', component: TechniciensalleDetailsComponent},
  {path: 'matiere', component: MatiereComponent},
  {path: 'matiere/creer', component: MatiereDetailsComponent},
  {path: 'matiere/:id', component: MatiereDetailsComponent},
  {path: 'technicien', component: TechnicienComponent},
  {path: 'planning', component: DemoComponent}
];
