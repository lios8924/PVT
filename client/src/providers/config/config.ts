import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

declare var google: any;

@Injectable()
export class ConfigProvider {

  configUrl = "assets/config.json";

  constructor(public http: HttpClient) {  }
  
  getConfig() {
    return new Promise((resolve, reject) => {
      this.http.get(this.configUrl).subscribe(resp => {
        var config: Config = {
          database: resp["database"],
          lampIcon: {
            url: resp["lampIcon"]["url"],
            scaledSize: new google.maps.Size(resp["lampIcon"]["size"], resp["lampIcon"]["size"])
          }
        }

        //return config data
        resolve(config);
      }, err => {
        reject(err);
      });
    });
  }
}

export interface Config {
  database: string;
  lampIcon: {
    url: string,
    scaledSize: any
  };
}
