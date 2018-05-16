import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { ConfigProvider } from '../../providers/config/config';

declare var google: any;

@Injectable()
export class LampProvider {

  lampDatabaseLocation: string = null;
  configPromise: Promise<{}>;

  constructor(public http: HttpClient, public configP: ConfigProvider) {
    this.configPromise = this.configP.getConfig();
    this.configPromise.then(data => {
      this.lampDatabaseLocation = data["lampDatabaseLocation"];
    });
  }

  async getLamps() {

    await this.configPromise;

    if (this.lampDatabaseLocation == null) {
      console.error("this.lampDatabaseLocation is not set.");
      return null;
    }

    return new Promise((resolve, reject) => {
      this.http.get(this.lampDatabaseLocation).subscribe(resp => {
        for (let i in resp) {
          resp[i].LatLng = new google.maps.LatLng(resp[i]["lat"], resp[i]["lng"]);
        }
        resolve(resp);
      }, err => {
        reject(err);
      });
    });
  }

  async captureLamp(id: Number, team: String) {

    await this.configPromise;

    console.log("Capture lamp id: " + id + " for faction: " + team);

    let headers = new HttpHeaders();
    headers = headers.set("Accept", 'application/json');
    headers = headers.set('Content-Type', 'application/json');

    let body = JSON.stringify({
      lamp: id,
      team: team
    });

    this.http.put(this.lampDatabaseLocation + "/capture", body, { headers: headers }).subscribe(data => {
      console.log(data);
    }, err => {
      console.error(err);
    });
  }
}
