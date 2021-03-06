
import {HttpClientModule} from '@angular/common/http';
import 'core-js/es6/reflect';
import 'core-js/es7/reflect';
import 'zone.js/dist/zone';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {routes} from './route';
import {FormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {InscriptionStagiaireComponent} from './inscriptionStagiaire/inscriptionStagiaire.component';
import {CalendarHeaderComponent} from './demo-utils/calendar-header.component';
import {DemoComponent} from './demo/component';
import {DemoUtilsComponent} from './demo-utils/demo-utils.component';
import {DemoModule} from './demo/module';
import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CompetenceService} from './service/competence.service';
import {FormationService} from './service/formation.service';
import {MaterielService} from './service/materiel.service';
import {MatiereService} from './service/matiere.service';
import {ModuleService} from './service/module.service';
import {RessourceHumaineService} from './service/ressource-humaine.service';
import {NgModule} from '@angular/core';
import { RhDetailComponent } from './rh/rh-detail/rh-detail.component';
import {RhComponent} from './rh/rh.component';
import { InscriptiontechnicienComponent } from './inscriptiontechnicien/inscriptiontechnicien.component';
import { InscriptionformateurComponent } from './inscriptionformateur/inscriptionformateur.component';
import { InscriptiongestionnaireComponent } from './inscriptiongestionnaire/inscriptiongestionnaire.component';
import { GestionnaireDetailComponent } from './rh/rh-detail/gestionnaire-detail/gestionnaire-detail.component';
import { StagiaireDetailComponent } from './rh/rh-detail/stagiaire-detail/stagiaire-detail.component';
import { TechnicienDetailsComponent } from './rh/rh-detail/technicien-details/technicien-details.component';
import { DashboardComponent } from './dashboard/dashboard.component';import { MatiereDetailsComponent } from './matiere/matiere-details/matiere-details.component';
import { MatiereComponent } from './matiere/matiere.component';
import { TechnicienDetailComponent } from './technicien/technicien-detail/technicien-detail.component';
import { TechniciensalleDetailsComponent } from './technicien/technicien-detail/techniciensalle-details/techniciensalle-details.component';
import { TechnicienvideoDetailComponent } from './technicien/technicien-detail/technicienvideo-detail/technicienvideo-detail.component';
import { TechnicienComponent } from './technicien/technicien.component';

@NgModule({
  declarations: [
    AppComponent,
    InscriptionStagiaireComponent,
    DemoUtilsComponent, HomeComponent,
    
    InscriptionStagiaireComponent, RhDetailComponent, RhComponent, 
    InscriptiontechnicienComponent, InscriptionformateurComponent, InscriptiongestionnaireComponent,
    GestionnaireDetailComponent, StagiaireDetailComponent, TechnicienDetailsComponent, DashboardComponent,
    TechnicienComponent, TechnicienDetailComponent, TechniciensalleDetailsComponent, TechnicienvideoDetailComponent, 
    MatiereDetailsComponent, 
    MatiereComponent
  ],
  imports: [
    BrowserModule, FormsModule, RouterModule.forRoot(routes), BrowserAnimationsModule, DemoModule, HttpClientModule
  ],
  providers: [RessourceHumaineService, ModuleService, MatiereService, MaterielService, FormationService, CompetenceService],
  bootstrap: [AppComponent]
})
export class AppModule {}
platformBrowserDynamic().bootstrapModule(AppModule).then(ref => {
  // Ensure Angular destroys itself on hot reloads.
  if (window['ngRef']) {
    window['ngRef'].destroy();
  }
  window['ngRef'] = ref;

  // Otherwise, log the boot error
}).catch(err => console.error(err));
 
