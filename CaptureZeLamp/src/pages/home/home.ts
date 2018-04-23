import { Component, ViewChild, ElementRef } from '@angular/core';
import { NavController } from 'ionic-angular';

import { Geolocation } from '@ionic-native/geolocation';

import { ConfigProvider, Config } from '../../providers/config/config';

declare var google: any;

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  config: Config = { database: null };
  map: any;
  positionMarker: any;
  @ViewChild('map') mapElement: ElementRef;

  constructor(public navCtrl: NavController, public geo: Geolocation, public configProvider: ConfigProvider) {
    this.showConfig();
    this.initMap();
  }

  showConfig() {
    this.configProvider.getConfig().subscribe(resp => {
      this.config = resp;
      console.log(this.config);
    });

    /*
    this.configProvider.getConfig().subscribe(resp => {
      this.config = resp;
      console.log(this.config);
    }, err => {
      console.error(err);
    });
    */
  }

  initMap() {
    this.geo.getCurrentPosition({ maximumAge: 3000, timeout: 5000, enableHighAccuracy: true }).then(resp => {
      let myLocation = new google.maps.LatLng(resp.coords.latitude, resp.coords.longitude);
      this.map = new google.maps.Map(this.mapElement.nativeElement, {
        zoom: 15,
        center: myLocation
      });

      this.positionMarker = new google.maps.Marker({
        position: myLocation,
        map: this.map
      });
    }, err => {
      console.error("Error getting location:", err);
    })
  }
}
