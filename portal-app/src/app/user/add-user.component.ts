import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './add-user.component.html'
})
export class AddUserComponent {

  user: User = new User();
  routerNav: Router;
  constructor(private router: Router, private userService: UserService) {
		this.routerNav=router
  }

  createUser(): void {
    this.userService.createUser(this.user)
        .subscribe( data => {
           this.routerNav.navigate(['/add-success']);
        });
  };

}
