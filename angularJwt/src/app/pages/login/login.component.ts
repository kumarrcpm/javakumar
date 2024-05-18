import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  constructor(private http: HttpClient, private router: Router) {}

  ngOnInit() {}

  loginObj: any = {
    username: '',
    password: '',
  };

  apiresponse: any;

  login(username: any, password: any) {
    this.http
      .post('http://localhost:8081/api/authenticate', this.loginObj, {
        observe: 'response',
      })
      .subscribe((res: any) => {
        debugger;
        if (res.status == 201) {         
          localStorage.setItem('token', res.body.CommonResponse.token);
          localStorage.setItem('refreshToken', res.body.CommonResponse.refreshToken);
          this.router.navigateByUrl('/layout');
        } else {
          
          alert('Please Check your Login Credentials');
        }
      });
  }
}
