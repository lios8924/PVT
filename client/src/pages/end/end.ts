import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { SocialSharing } from '@ionic-native/social-sharing';

import {LoginPage} from '../login/login';

/**
 * Generated class for the EndPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-end',
  templateUrl: 'end.html',
})
export class EndPage {

  message:string = null;

  constructor(public navCtrl: NavController, public navParams: NavParams, public socialSharing: SocialSharing ) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad EndPage');
  }
  share(){
    this.socialSharing.share(this.message).then(() => {

    }).catch(() => {

});
  }

  signout() {
      localStorage.clear();
      this.navCtrl.push(LoginPage);
  }
}
