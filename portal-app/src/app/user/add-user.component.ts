import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user.model';
import { UserService } from './user.service';

@Component({
  templateUrl: './add-user.component.html'
})
export class AddUserComponent {

  user: User = new User();
  router: Router;
  constructor(private router: Router, private userService: UserService) {

  }

  createUser(): void {
    this.userService.createUser(this.user)
        .subscribe( data => {
           debugger
           alert("User created successfully.");
           this.router.navigate(['/add-success']);
        });
	
  };

}
