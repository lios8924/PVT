import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ConfigProvider {

  configUrl = "assets/config.json";

  constructor(public http: HttpClient) {  }

  getConfig() {
    return this.http.get<Config>(this.configUrl);
  }
}

export interface Config {
  database: string;
}
