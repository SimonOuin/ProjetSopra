import {Routes} from '@angular/router';
import {HomeComponent} from './home/home.component';
import {RhDetailComponent} from './rh/rh-detail/rh-detail.component';
import {RhComponent} from './rh/rh.component';

export const routes: Routes = [
  {path: 'rh', component: RhComponent},
  {path: 'rhdetail/:id', component: RhDetailComponent},
  {path: 'rhdetail', component: RhDetailComponent}
];
