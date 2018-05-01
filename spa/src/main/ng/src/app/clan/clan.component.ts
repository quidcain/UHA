import {Component, Input, OnInit} from '@angular/core';
import {ClanService} from "../clan.service";
import {Clan} from "../clan";
import {ActivatedRoute} from "@angular/router";
import {Location} from "@angular/common";

@Component({
  selector: 'app-clans',
  templateUrl: './clan.component.html',
  styleUrls: ['./clan.component.css']
})
export class ClanComponent implements OnInit {
  @Input() clan: Clan;

  constructor(
    private route: ActivatedRoute,
    private clanService: ClanService,
    private location: Location
  ) { }

  ngOnInit() {
    this.getClan();
  }

  getClan() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.clanService.getClan(id)
      .subscribe(clan => this.clan = clan);
  }

  goBack() {
    this.location.back();
  }

  save() {
    this.clanService.updateClan(this.clan)
      .subscribe();
  }
}
