import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

declare var google: any;

@Injectable()
export class LampProvider {

  constructor(public http: HttpClient) {  }

  getLamps() {
    return new Promise((resolve, reject) => {
      this.http.get("assets/lamps.json").subscribe(resp => {
        for (let i in resp) {
          resp[i].LatLng = new google.maps.LatLng(resp[i].lat, resp[i].lng)
        }
        resolve(resp);
      }, err => {
        reject(err);
      });
    });
  }
}
