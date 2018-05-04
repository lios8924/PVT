import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { ConfigProvider } from '../../providers/config/config';

declare var google: any;

@Injectable()
export class LampProvider {

  lampDatabaseLocation: string = null;
  configPromise: Promise<{}>;

  constructor(public http: HttpClient, public configP: ConfigProvider) {
    this.configPromise = this.configP.getConfig()
  }

  async getLamps() {

    await this.configPromise.then(data => {
      this.lampDatabaseLocation = data["lampDatabaseLocation"];
    });

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

}
