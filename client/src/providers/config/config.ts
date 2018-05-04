import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

declare var google: any;

@Injectable()
export class ConfigProvider {

  configUrl = "assets/config.json";
  configPromise: Promise<{}>;
  config;

  constructor(public http: HttpClient) {  }

  async getConfig() {
    if (this.configPromise != null) {
      await this.configPromise;
      return new Promise((r, reject) => { r(this.config)})
    }

    this.configPromise = new Promise((resolve, reject) => {
      this.http.get(this.configUrl).subscribe(resp => {
        this.config = resp;
        this.config["lampIcon"].scaledSize = new google.maps.Size(this.config["lampIcon"]["scaledSize"], this.config["lampIcon"]["scaledSize"]);

        //return config data
        resolve(this.config);
      }, err => {
        reject(err);
      });
    });

    return this.configPromise;
  }
}
