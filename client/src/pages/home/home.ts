import { Component, ViewChild, ElementRef } from '@angular/core';
import { NavController, Platform } from 'ionic-angular';

import { Geolocation } from '@ionic-native/geolocation';

import { ConfigProvider } from '../../providers/config/config';

declare var google: any;

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  config: any = { database: null, lampIcon: null };
  map: any;
  positionMarker: any;
  lampMarkers = [];
  @ViewChild('map') mapElement: ElementRef;

  tempLocation: any;

  constructor(public navCtrl: NavController, public geo: Geolocation, public configProvider: ConfigProvider, public platform: Platform) {
    platform.ready().then(() => {
      this.showConfig();
      this.initLamps();
      this.initMap();
    });
  }

  showConfig() {
    this.configProvider.getConfig().then(data => {
      this.config = data;
      this.updateLampIcons();
    });
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

      this.setLampMarkers(this.map);

    }, err => {
      console.error("Error getting location:", err);
    })
  }

  initLamps() {
    //Wow! big database
	//location for Stockholm
    let locations = [new google.maps.LatLng(59.3293, 18.0686)];
    
    for (let i in locations) {
      this.addLampMarker(locations[i]);
    }
  }

  addLampMarker(location) {
    this.lampMarkers.push(new google.maps.Marker({
      position: location,
      icon: this.config.lampIcon
    }));
  }

  setLampMarkers(map) {
    for (let i in this.lampMarkers) {
      this.lampMarkers[i].setMap(map);
    }
  }

  updateLampIcons() {
    for (let i in this.lampMarkers) {
      this.lampMarkers[i].icon = this.config.lampIcon;
    }
  }
}
