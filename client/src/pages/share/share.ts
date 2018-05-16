import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { SocialSharing } from '@ionic-native/social-sharing';

/**
 * Generated class for the SharePage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-share',
  templateUrl: 'share.html',
})
export class SharePage {

  message:string = null;

  constructor(public navCtrl: NavController, public navParams: NavParams, public socialSharing: SocialSharing ) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SharePage');
  }

  share(){
    this.socialSharing.share(this.message).then(() => {

    }).catch(() => {
  // Sharing via email is not possible
});
  }

}
