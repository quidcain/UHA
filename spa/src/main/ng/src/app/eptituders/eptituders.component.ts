import { Component, OnInit } from '@angular/core';
import {EptituderService} from "../eptituder.service";
import {EptituderPage} from "../eptituder.page";

@Component({
  selector: 'app-eptituders',
  templateUrl: './eptituders.component.html',
  styleUrls: ['./eptituders.component.css']
})
export class EptitudersComponent implements OnInit {
  eptitudersPage: EptituderPage;

  constructor(private eptituderService: EptituderService) { }

  ngOnInit() {
    this.getEptituders();
  }

  getEptituders(): void {
    this.eptituderService.getEptituders()
      .subscribe(eptitudersPage => this.eptitudersPage = eptitudersPage);
  }

}
