import {Component, Input, OnInit} from '@angular/core';
import {ClanService} from "../clan.service";
import {Clan} from "../clan";
import {ClanPage} from "../clan.page";
import {EptituderPage} from "../eptituder.page";
import {EptituderService} from "../eptituder.service";
import {Eptituder} from "../eptituder";

@Component({
  selector: 'app-clans',
  templateUrl: './clans.component.html',
  styleUrls: ['./clans.component.css']
})
export class ClansComponent implements OnInit {
  @Input() newClan: Clan;
  clanPage: ClanPage;
  eptituderPage: EptituderPage;

  constructor(
    private clanService: ClanService,
    private eptituderService: EptituderService
  ) { }

  ngOnInit() {
    this.newClan = new Clan();
    this.getClans();
    this.getEptituders();
  }

  getClans(): void {
    this.clanService.getClans()
      .subscribe(clanPage => this.clanPage = clanPage);
  }

  getEptituders(): void {
    this.eptituderService.getEptituders()
      .subscribe(eptituderPage => this.eptituderPage = eptituderPage);
  }

  createRequest(clan) {
    let request = Object.assign({}, clan);
    request.eptituders = [];
    clan.eptituders
      .forEach((eptituder) => request.eptituders.push(<Eptituder>{id: eptituder.id}));
    return request;
  }

  save() {
    this.clanService.addClan(this.createRequest(this.newClan))
      .subscribe();
  }
}
