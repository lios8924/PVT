import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import {HomePage} from '../home/home';
import {LoginPage} from '../login/login';
import { ProflieProvider } from '../../providers/proflie/proflie';

@IonicPage()
@Component({
  selector: 'page-lobby',
  templateUrl: 'lobby.html',
})
export class LobbyPage {
  
  constructor(public navCtrl: NavController, public navParams: NavParams, public profile: ProflieProvider) {

  }

  setTeam(team) {
    this.profile.setTeam(team);
    this.navCtrl.push(HomePage);
  }

    signout() {
      this.profile.signout();
      localStorage.clear();
      this.navCtrl.push(LoginPage);
    }
}
