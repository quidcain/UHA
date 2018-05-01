import {Component, Input, OnInit} from '@angular/core';
import {ClanService} from "../clan.service";
import {Clan} from "../clan";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";
import {Eptituder} from "../eptituder";
import {EptituderService} from "../eptituder.service";
import {EptituderPage} from "../eptituder.page";

@Component({
  selector: 'app-clans',
  templateUrl: './clan.component.html',
  styleUrls: ['./clan.component.css']
})
export class ClanComponent implements OnInit {
  @Input() clan: Clan;
  eptituderPage: EptituderPage;

  constructor(
    private route: ActivatedRoute,
    private clanService: ClanService,
    private eptituderService: EptituderService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getClan();
    this.getEptituders();
  }

  getEptituders(): void {
    this.eptituderService.getEptituders()
      .subscribe(eptituderPage => this.eptituderPage = eptituderPage);
  }

  getClan() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.clanService.getClan(id)
      .subscribe(clan => this.clan = clan);
  }

  goBack() {
    this.location.back();
  }

  createRequest(clan) {
    let request = Object.assign({}, clan);
    request.eptituders = [];
    clan.eptituders
      .forEach((eptituder) => request.eptituders.push(<Eptituder>{id: eptituder.id}));
    return request;
  }

  save() {
    this.clanService.updateClan(this.createRequest(this.clan))
      .subscribe();
  }
}
