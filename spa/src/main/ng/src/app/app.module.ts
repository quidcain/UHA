import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { AppComponent } from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { HomeComponent } from './home/home.component';
import { ContactsComponent } from './contacts/contacts.component';
import { EptitudersComponent } from './eptituders/eptituders.component';
import {EptituderService} from "./eptituder.service";
import { EptituderComponent } from './eptituder/eptituder.component';


@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
  ],
  declarations: [
    AppComponent,
    HomeComponent,
    ContactsComponent,
    EptitudersComponent,
    EptituderComponent
  ],
  providers: [EptituderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
