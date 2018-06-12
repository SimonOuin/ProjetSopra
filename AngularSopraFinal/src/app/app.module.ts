
import 'core-js/es6/reflect';
import 'core-js/es7/reflect';
import 'zone.js/dist/zone';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { routes } from './route';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { InscriptionComponent } from './inscription/inscription.component';
import { CalendarHeaderComponent } from './demo-utils/calendar-header.component';
import { DemoComponent } from './demo/component';
import { DemoUtilsComponent } from './demo-utils/demo-utils.component';
import { DemoModule } from './demo/module';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    DemoUtilsComponent,
    InscriptionComponent
  ],
  imports: [
    BrowserModule,FormsModule,RouterModule.forRoot(routes), BrowserAnimationsModule, DemoModule
  ],
  providers: [],
  bootstrap: [AppComponent, DemoComponent]
})
export class AppModule { }
platformBrowserDynamic().bootstrapModule(AppModule).then(ref => {
  // Ensure Angular destroys itself on hot reloads.
  if (window['ngRef']) {
    window['ngRef'].destroy();
  }
  window['ngRef'] = ref;

  // Otherwise, log the boot error
}).catch(err => console.error(err));
