import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
// import * as _moment from 'moment';
// import { Moment } from 'moment';

// const moment = _moment;

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  events: string[] = [];
  opened: boolean | undefined;

  shouldRun = true;

  buttonDisabled : boolean =false;
  //required : boolean=false;

  inputReadonly = true;

  isSubmitted= false;
  
  constructor() { }

  ngOnInit(): void {
  }

 
  data={
    way:"",
    from:"",
    to:"",
    adults:"",
    children:"",
    infants:"",
    departOn:"",
    returnOn:""
};
onItemChange(value:any){
  console.log(" Value is : ", value );
}

onClick(){
  this.buttonDisabled=true;
}

onClicked(){
  this.buttonDisabled=false;
  //this.required=true;
}

  doSubmit(){
    console.log(this.data);  
  }
  
  minDate= new Date();
  //maxDate = new Date(this.minDate.getMonth() + 3)
  public toggleInputReadonly() {
    this.inputReadonly = !this.inputReadonly;
  }

  // submitForm(form: NgForm) {
  //   this.isSubmitted = true;
  //   if(!form.valid) {
  //     return false;
  //   } else {
  //   alert(JSON.stringify(form.value))
  //   }
  // }

  // form = new FormGroup({

  //   form: new FormControl('', [Validators.required]),
  //   to: new FormControl('', [Validators.required])
  // })
  // minDate: Moment;
  // maxDate: Moment;
  // myDateFilter = (m: Moment | null): boolean => {
  //   const dateNum = (m || moment()).date();
  //   return dateNum >= 10 && dateNum <= 25;
  // } 

}