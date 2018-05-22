import { Component } from '@angular/core';
import { AlertController, IonicPage, NavController, NavParams } from 'ionic-angular';

import 'rxjs/add/operator/map';
import { ConfigProvider } from '../../providers/config/config';

import { HttpClient, HttpHeaders } from '@angular/common/http';

@IonicPage()
@Component({
  selector: 'page-signup',
  templateUrl: 'signup.html',
})
export class SignupPage {

  API: string;
  data: any;
  usernameinput: string;
  passwordinput: string;
  configPromise: Promise<{}>;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient, public alertCtrl: AlertController, public configP: ConfigProvider) {
    this.configPromise = this.configP.getConfig();
    this.configPromise.then(data => {
      this.API = data["database"] + "signup";
    });
  }
  
  //Funkar, men 0 säkerhet
  async signup() {
    await this.configPromise;

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
          //console.log("User ", this.usernameinput, " added successfully");
          this.navCtrl.pop();
        }
        else {
          let alert = this.alertCtrl.create({
            title: 'User with that name already exist!',
            buttons: ['Dismiss']
          });
          alert.present();
          //console.log(data , "User already exist!");
        }
      },
      err => {
        console.error("Signup errer:", err);
      }
    );

  }

  goBack() {
    this.navCtrl.pop();
  }

}
