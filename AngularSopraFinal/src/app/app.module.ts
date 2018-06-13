
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
@NgModule({
  declarations: [
    AppComponent,
    InscriptionStagiaireComponent,
    DemoUtilsComponent,
    InscriptionStagiaireComponent, RhDetailComponent, RhComponent
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
 
