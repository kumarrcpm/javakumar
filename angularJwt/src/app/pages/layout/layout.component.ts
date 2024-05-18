import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-layout',
  templateUrl: './layout.component.html',
  styleUrls: ['./layout.component.css']
})
export class LayoutComponent implements OnInit {
  
  constructor (private router: Router, private http: HttpClient){}
  
  ngOnInit(){
  this.http.get('http://localhost:8081/api/welcomeAll',{withCredentials : true, observe:'response'}).subscribe((res : any)=>{
  
  console.log(res.status);
  })
  
  
  }

}
