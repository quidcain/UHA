import {Component, Input, OnInit} from '@angular/core';
import {ClanService} from "../clan.service";
import {Clan} from "../clan";
import {ClanPage} from "../clan.page";

@Component({
  selector: 'app-clans',
  templateUrl: './clans.component.html',
  styleUrls: ['./clans.component.css']
})
export class ClansComponent implements OnInit {
  @Input() newClan: Clan;
  clanPage: ClanPage;

  constructor(private clanService: ClanService) { }

  ngOnInit() {
    this.newClan = new Clan();
    this.getClans();
  }

  getClans(): void {
    this.clanService.getClans()
      .subscribe(clanPage => this.clanPage = clanPage);
  }

  save() {
    this.clanService.addClan(this.newClan)
      .subscribe();
  }
}
