import {Injectable} from "@angular/core";
import {HttpClient, HttpHeaders} from "@angular/common/http";

import {Observable} from "rxjs/Observable";
import {EptituderPage} from "./eptituder.page";
import {Eptituder} from "./eptituder";

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class EptituderService {

  private eptitudersUrl = '/api/eptituders';  // URL to web api

  constructor(private http: HttpClient) {}

  getEptituders(): Observable<EptituderPage> {
    return this.http.get<EptituderPage>(this.eptitudersUrl);
  }

  getEptituder(id: number): Observable<Eptituder> {
    const url = `${this.eptitudersUrl}/${id}`;
    return this.http.get<Eptituder>(url);
  }

  addEptituder(eptituder: Eptituder): Observable<Eptituder> {
    return this.http.post<Eptituder>(this.eptitudersUrl, eptituder, httpOptions);
  }

  updateEptituder(eptituder: Eptituder): Observable<Eptituder> {
    const url = `${this.eptitudersUrl}/${eptituder.id}`;
    return this.http.put<Eptituder>(url, eptituder, httpOptions);
  }

  delete(eptituder: Eptituder) {
    const url = `${this.eptitudersUrl}/${eptituder.id}`;
    return this.http.delete(url, httpOptions);
  }
}
