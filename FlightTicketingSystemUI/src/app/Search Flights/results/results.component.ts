import { Component, OnInit } from '@angular/core';
import { UserServiceService } from "../user-service.service"
import { HttpClientModule } from "@angular/common/http";
//import { Observable } from 'rxjs';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {

  dataInfo: any;

  constructor(private user : UserServiceService) {
  
  }
  ngOnInit(){
  this.user.getData().subscribe(data =>{
  this.dataInfo = data;
  })
  }
  }
