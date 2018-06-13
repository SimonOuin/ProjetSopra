import { DashboardComponent } from './dashboard/dashboard.component';
import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import { GestionnaireDetailComponent } from './rh/rh-detail/gestionnaire-detail/gestionnaire-detail.component';
import {RhDetailComponent} from './rh/rh-detail/rh-detail.component';
import { StagiaireDetailComponent } from './rh/rh-detail/stagiaire-detail/stagiaire-detail.component';
import { TechnicienDetailComponent } from './rh/rh-detail/technicien-detail/technicien-detail.component';
import {RhComponent} from './rh/rh.component';

export const routes: Routes = [
  {path: 'rh', component: RhComponent},
  {path: 'rhdetail/:id', component: RhDetailComponent},
  {path: 'rhdetail', component: RhDetailComponent},
  {path: 'stagiairedetail/:id', component: StagiaireDetailComponent},
  {path: 'stagiairedetail', component: StagiaireDetailComponent},
  {path: 'gestionnairedetail/:id', component: GestionnaireDetailComponent},
  {path: 'gestionnairedetail', component: GestionnaireDetailComponent},
  {path: 'techniciendetail/:id', component: TechnicienDetailComponent},
  {path: 'techniciendetail', component: TechnicienDetailComponent},
  {path: 'dashboard', component: DashboardComponent}
];
