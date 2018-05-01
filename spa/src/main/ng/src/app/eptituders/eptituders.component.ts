import {Component, Input, OnInit} from '@angular/core';
import {EptituderService} from "../eptituder.service";
import {EptituderPage} from "../eptituder.page";
import {Eptituder} from "../eptituder";

@Component({
  selector: 'app-eptituders',
  templateUrl: './eptituders.component.html',
  styleUrls: ['./eptituders.component.css']
})
export class EptitudersComponent implements OnInit {
  @Input() newEptituder: Eptituder;
  eptituderPage: EptituderPage;

  constructor(private eptituderService: EptituderService) { }

  ngOnInit() {
    this.newEptituder = new Eptituder();
    this.getEptituders();
  }

  getEptituders(): void {
    this.eptituderService.getEptituders()
      .subscribe(eptituderPage => this.eptituderPage = eptituderPage);
  }

  save() {
    this.eptituderService.addEptituder(this.newEptituder)
      .subscribe();
  }
}
