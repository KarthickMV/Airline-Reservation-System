import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import{BrowserAnimationsModule} from '@angular/platform-browser/animations';
import{ NoopAnimationsModule} from '@angular/platform-browser/animations';
import { MatCheckboxModule } from '@angular/material/checkbox';
import {MatRadioModule} from '@angular/material/radio';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from "@angular/material/select";
import {MatButtonModule} from '@angular/material/button'; 
import { MatSidenavModule } from "@angular/material/sidenav";
import {MatTableModule} from '@angular/material/table';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import {MatSlideToggleModule} from '@angular/material/slide-toggle'; 
import {HttpClientModule} from "@angular/common/http"; 
 //import { MatLabelModule } from "@angular/material/";
import { filter, map } from 'rxjs/operators';

//import { MatMomentDateModule } from 'ngx-moment';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SearchComponent } from './search/search.component';
import { ToggleComponent } from './toggle/toggle.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { ResultsComponent } from './results/results.component';
//import { Observable } from 'rxjs';

@NgModule({
  declarations: [
    AppComponent,
    SearchComponent,
    ToggleComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    LogoutComponent,
    ResultsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule, ReactiveFormsModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatSidenavModule,
    MatRadioModule,
    MatInputModule,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule,
    MatNativeDateModule,
    MatSelectModule,
    MatButtonModule,
    MatTableModule,
    AppRoutingModule,
    MatSlideToggleModule,
   HttpClientModule,
   //Observable
   
    //MatMomentDateModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
