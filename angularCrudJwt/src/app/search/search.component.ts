import { Component, OnInit } from '@angular/core';
import { UserregistrationService } from '../userregistration.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {

  users: any;

  constructor (private service: UserregistrationService){}

  ngOnInit(){
    let resp = this.service.getUsers();
    resp.subscribe((data)=> this.users=data);
  }


  public deleteUser(id:number){
    let resp= this.service.deleteUser(id);
    resp.subscribe((data)=>this.users=data);
   }

}
