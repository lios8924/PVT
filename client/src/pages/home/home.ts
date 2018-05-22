import { Component, ViewChild, ElementRef } from '@angular/core';
import { NavController, Platform, NavParams } from 'ionic-angular';

import { Geolocation } from '@ionic-native/geolocation';

import { ConfigProvider } from '../../providers/config/config';
import { ProflieProvider } from '../../providers/proflie/proflie';
import { LampMarkers } from '../../assets/ts/LampMarkers';

import {EndPage} from '../end/end';


declare var google: any;

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  map: any = null;
  positionMarker: any;
  @ViewChild('map') mapElement: ElementRef;

  styles = {
    default: null,
    hide: [
      {
        featureType: 'poi.business',
        stylers: [{ visibility: 'off' }]
      },
      {
        featureType: 'transit',
        elementType: 'labels.icon',
        stylers: [{ visibility: 'off' }]
      }
    ]
  };

  constructor(public navCtrl: NavController, public navParams: NavParams, public geo: Geolocation, public configProvider: ConfigProvider, public platform: Platform, public profile: ProflieProvider, public lampMarkers: LampMarkers) {
    platform.ready().then(() => {
      this.initMap();
    });
  }

  initMap() {
    this.geo.getCurrentPosition({ maximumAge: 3000, timeout: 5000, enableHighAccuracy: true }).then((resp) => {
      let myLocation = new google.maps.LatLng(resp.coords.latitude, resp.coords.longitude);

      this.map = new google.maps.Map(this.mapElement.nativeElement, {
        zoom: 15,
        center: myLocation,
        disableDefaultUI: true,
        options: { styles: this.styles['hide'] }
      });

      this.positionMarker = new google.maps.Marker({
        position: myLocation,
        map: this.map
      });
      
      this.lampMarkers.initLamps(this.map);

      this.geo.watchPosition({ maximumAge: 3000, timeout: 5000, enableHighAccuracy: true }).subscribe(resp => {
        if (resp.coords == undefined) return;

        let myLocation = new google.maps.LatLng(resp.coords.latitude, resp.coords.longitude);
        this.positionMarker.setPosition(myLocation);
      }, err => {
        console.error("Error getting location:", err);
      });

    });
  }

  endgame(){
    this.navCtrl.push(EndPage);
  }
}
