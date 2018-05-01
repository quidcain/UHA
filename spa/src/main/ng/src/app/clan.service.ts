import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

import {Observable} from "rxjs/Observable";
import {Clan} from "./clan";
import {ClanPage} from "./clan.page";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class ClanService {

  private clansUrl = '/uha/api/clans';  // URL to web api

  constructor(private http: HttpClient) {}

  getClans(): Observable<ClanPage> {
    return this.http.get<ClanPage>(this.clansUrl);
  }

  getClan(id: number): Observable<Clan> {
    const url = `${this.clansUrl}/${id}`;
    return this.http.get<Clan>(url);
  }

  addClan(clan: Clan): Observable<Clan> {
    return this.http.post<Clan>(this.clansUrl, clan, httpOptions);
  }

  updateClan(clan: Clan): Observable<Clan> {
    const url = `${this.clansUrl}/${clan.id}`;
    return this.http.put<Clan>(url, clan, httpOptions);
  }
}
