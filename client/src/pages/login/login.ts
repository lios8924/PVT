import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams, AlertController } from 'ionic-angular';

import { SignupPage } from '../signup/signup';
import { LobbyPage } from '../lobby/lobby';
import { ConfigProvider } from '../../providers/config/config';
import { ProflieProvider } from '../../providers/proflie/proflie';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {

  API: string;
  data: any;
  usernameinput: string;
  passwordinput: string;
  configPromise: Promise<{}>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient, public alertCtrl: AlertController, public configP: ConfigProvider, public profile: ProflieProvider) {
    this.configPromise = this.configP.getConfig();
    this.configPromise.then(data => {
      this.API = data["database"] + "login";
    });
  }

  signup() {
    this.navCtrl.push(SignupPage);
  }

  async loginPost() {

    await this.configPromise;
    //this.API = 'http://localhost:8080/login';

    var headers = new HttpHeaders();
    headers = headers.set("Accept", 'application/json');
    headers = headers.set('Content-Type', 'application/json');

    var body = JSON.stringify({
      username: this.usernameinput,
      password: this.passwordinput
    });

    //console.log(this.API, body, headers);

    this.http.post(this.API, body, { headers: headers }).map(data => data).subscribe(
      data => {
        if (data == 0) {

          //localStorage.setItem('username', this.usernameinput);
          //localStorage.setItem('loggedIn', 'true');
          this.profile.setUsername(this.usernameinput.toLowerCase());

          this.navCtrl.push(LobbyPage);

        } else {

          let alert = this.alertCtrl.create({
            title: 'Invalid username or password',
            buttons: ['Dismiss']
          });
          alert.present();


          console.log(data, "No existing user");
        }
      },
      err => {
        console.error('Login error:', err);
      }
    );

  }

}
