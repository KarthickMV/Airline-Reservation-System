import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http : HttpClient) {}
getData(){
return this.http.get('https://jsonplaceholder.typicode.com/users')
}


}
