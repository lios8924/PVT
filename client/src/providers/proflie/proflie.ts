import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class ProflieProvider {

  username: string;
  team: string;
  teamColor: string;
  teamColorIndex = {
    red: "#ff0000",
    blue: "#0000ff"
  }

  constructor(public http: HttpClient) {  }

  setUsername(username: string) {
    this.username = username;
  }

  setTeam(team: string) {
    this.team = team.toLowerCase();
    this.teamColor = this.getTeamColor(this.team);
  }

  getTeamColor(team: string) {
    return this.teamColorIndex[team];
  }

  signout() {
    this.username = null;
    this.team = null;
    this.teamColor = null;
  }
}
