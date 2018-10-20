import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { UserComponent } from './user/user.component';
import {AddUserComponent} from './user/add-user.component';
import {AddUserSuccessComponent} from './user/add-user-success.component';

const routes: Routes = [
  { path: '', redirectTo: 'add', pathMatch: 'full' },
  { path: 'users', component: UserComponent },
  { path: 'add', component: AddUserComponent },
  { path: 'add-success', component: AddUserSuccessComponent }
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }
