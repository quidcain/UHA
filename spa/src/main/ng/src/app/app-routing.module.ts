import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent }   from './home/home.component';
import { ContactsComponent } from './contacts/contacts.component';
import {EptitudersComponent} from "./eptituders/eptituders.component";
import {EptituderComponent} from "./eptituder/eptituder.component";
import {ClansComponent} from "./clans/clans.component";
import {ClanComponent} from "./clan/clan.component";


const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'contacts', component: ContactsComponent },
  { path: 'eptituders', component: EptitudersComponent },
  { path: 'eptituders/:id', component: EptituderComponent },
  { path: 'clans', component: ClansComponent },
  { path: 'clans/:id', component: ClanComponent },
  /*{ path: 'events/', component: EventsComponent },
  { path: 'events/:id', component: EventDetailComponent },
  { path: 'examTemplates/', component: ExamTemplatesComponent },
  { path: 'examTemplates/:id', component: ExamTemplateDetailComponent },
  { path: 'questions/', component: QuestionsComponent },
  { path: 'questions/:id', component: QuestionDetailComponent }*/
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
