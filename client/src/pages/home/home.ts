import { Component, ViewChild, ElementRef } from '@angular/core';
import { NavController, Platform } from 'ionic-angular';

import { Geolocation } from '@ionic-native/geolocation';

import { ConfigProvider } from '../../providers/config/config';
import { LampProvider } from '../../providers/lamp/lamp';

declare var google: any;

@Component({
  selector: 'page-home',
  templateUrl: 'home.html'
})
export class HomePage {

  config: any = { lampIcon: null };
  map: any;
  positionMarker: any;
  lampMarkers = [];
  @ViewChild('map') mapElement: ElementRef;

  tempLocation: any;

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

  constructor(public navCtrl: NavController, public geo: Geolocation, public configProvider: ConfigProvider, public platform: Platform, public lampProvider: LampProvider) {
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
        map: this.map,
        icon: this.config.icon
      });

      this.setLampMarkers(this.map);

    }, err => {
      console.error("Error getting location:", err);
      return;
    });

    this.geo.watchPosition({ maximumAge: 3000, timeout: 5000, enableHighAccuracy: true }).subscribe(resp => {
      let myLocation = new google.maps.LatLng(resp.coords.latitude, resp.coords.longitude);
      this.positionMarker.setPosition(myLocation);
    }, err => {
      console.error("Error getting location:", err);
    });

  }

  initLamps() {
    this.lampProvider.getLamps().then(locations => {
      for (let i in locations) {
        this.addLampMarker(locations[i].id, locations[i].LatLng);
      }
    }, error => {
      console.error("Cant retrive lamp database.");
    });
    this.setLampMarkers(this.map);
  }

  addLampMarker(id: Number, location) {
    let lampMarker = new google.maps.Marker({
      id: id,
      position: location,
      map: this.map,
      icon: this.config.lampIcon,
      circle: null
    });
    lampMarker.addListener('click', e => {
      this.lampProvider.captureLamp(lampMarker.id, "red");
      if (lampMarker.circle == null) {

      }
    });
    this.lampMarkers.push(lampMarker);
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
