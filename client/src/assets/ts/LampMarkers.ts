import { Injectable } from '@angular/core';

import { LampProvider } from '../../providers/lamp/lamp';
import { ProflieProvider } from '../../providers/proflie/proflie';
import { ConfigProvider } from '../../providers/config/config';

declare var google;

@Injectable()
export class LampMarkers {
  lampMarkers = [];
  lampIcon = {
    null: null,
    red: null,
    blue: null
  };
  circleSize: number = 10;
 

  constructor(public lampProvider: LampProvider, public configProvider: ConfigProvider, public profile: ProflieProvider) {
    this.configProvider.getConfig().then(data => {
      this.lampIcon.null = { "url": data['lampIcon']["def"], "scaledSize": data['lampIcon']['scaledSize'] };
      this.lampIcon.red = { "url": data['lampIcon']["red"], "scaledSize": data['lampIcon']['scaledSize'] };
      this.lampIcon.blue = { "url": data['lampIcon']["blue"], "scaledSize": data['lampIcon']['scaledSize'] };
      this.circleSize = data["lampCircleSize"];

      this.updateLampIcons();
    });
  }

  initLamps(map) {
    this.lampProvider.getLamps().then(locations => {
      for (let i in locations) {
        this.addLampMarker(map, locations[i].id, locations[i].LatLng, locations[i].team);
      }
    }, error => {
      console.error("Cant retrive lamp database.");
    });
  }

  addLampMarker(map, id: number, location, team: string) {
    let lampMarker = new google.maps.Marker({
      id: id,
      position: location,
      map: map,
      icon: this.lampIcon[team],
      circle: null,
      team: team
    });

    if (team != null) {
      this.setLampMarkerTeam(map, lampMarker, team);
    }

    lampMarker.addListener('click', e => {
      let team = this.profile.team;
      this.lampProvider.captureLamp(lampMarker.id, team).then(r => {
        if (r == 1) {
          this.setLampMarkerTeam(map, lampMarker, team);
        } else {
          console.error("Cant capture, check server log for error mesage.");
        }
      }, err => {
        console.error("Capture http error:",err);
      });
    });

    this.lampMarkers.push(lampMarker);
  }

  setLampMarkerTeam(map, marker, team) {
    marker.team = team;
    
    marker.setIcon(this.lampIcon[team]);

    if (marker.circle == null) {
      marker.circle = new google.maps.Circle({
        strokeColor: this.profile.getTeamColor(marker.team),
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: this.profile.getTeamColor(marker.team),
        fillOpacity: 0.35,
        map: map,
        center: marker.position,
        radius: this.circleSize
      });
    } else {
      marker.circle.setOptions({
        fillColor: this.profile.getTeamColor(marker.team),
        strokeColor: this.profile.getTeamColor(marker.team)
      })
    }
  }

  setLampMarkers(map) {
    for (let i in this.lampMarkers) {
      this.lampMarkers[i].setMap(map);

      if (this.lampMarkers[i].circle != null) {
        this.lampMarkers[i].circle.setMap(map);
      }
    }
  }

  updateLampIcons() {
    for (let i in this.lampMarkers) {
      this.lampMarkers[i].setIcon(this.lampIcon[this.lampMarkers[i].team]);

      if (this.lampMarkers[i].circle != null) {
        this.lampMarkers[i].circle.setOptions({
          radius: this.circleSize
        })
      }
    }
  }
}
