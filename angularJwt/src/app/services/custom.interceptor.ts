import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class CustomInterceptor implements HttpInterceptor {

  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    const token = localStorage.getItem('token'); 
    
    let header = new HttpHeaders();

   if(token != null){
    header = header.append('Authorization',`Bearer ${token}`);
   }

   header = header.append('X-Requested-With', 'XMLHttpRequest');
    const newCloneRequest = request.clone({headers : header})
    return next.handle(newCloneRequest);
  }
}
