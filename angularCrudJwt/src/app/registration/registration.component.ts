import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserregistrationService } from '../userregistration.service';
import { Validators,FormGroup, FormControl } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css'],
})
export class RegistrationComponent implements OnInit {

  public user : User = new User();
  message: any;
  testform: any;

  constructor(private service: UserregistrationService, private http: HttpClient) {}

  ngOnInit() {}

  onSubmit(){
    let resp = this.service.doRegistration(this.user);
    resp.subscribe((resdata:any) => {(this.message = resdata.body);console.log(resdata.status,this.message);
      localStorage.setItem('loginToken', resdata.data.token);
    });

    
  }

  testformm=new FormGroup({
    name: new FormControl('',Validators.required),
    email: new FormControl('',Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$')),
    

  })
  get vname(){
    return this.testformm.get('name');
  }
  get vemail(){
    return this.testformm.get('email');
  }



}
