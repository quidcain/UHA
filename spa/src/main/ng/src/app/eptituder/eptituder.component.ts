import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { Location } from '@angular/common';

import {EptituderService} from "../eptituder.service";
import {Eptituder} from "../eptituder";

@Component({
  selector: 'app-eptituder',
  templateUrl: './eptituder.component.html',
  styleUrls: ['./eptituder.component.css']
})
export class EptituderComponent implements OnInit {
  @Input() eptituder: Eptituder;


  constructor(
    private route: ActivatedRoute,
    private eptituderService: EptituderService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getEptituder();
  }

  getEptituder() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.eptituderService.getEptituder(id)
      .subscribe(eptituder => this.eptituder = eptituder);
  }

  goBack() {
    this.location.back();
  }

  save() {
    this.eptituderService.updateEptituder(this.eptituder)
      .subscribe(() => this.goBack());
  }
}
