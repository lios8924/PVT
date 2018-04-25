import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import {SignupPage} from '../signup/signup';
import {HomePage} from '../home/home';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
/**
 * Generated class for the LoginPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-login',
  templateUrl: 'login.html',
})
export class LoginPage {



  //let API = 'http://localhost:8080/login?';
  API: any;
  data: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

  signup(){
    this.navCtrl.push(SignupPage)
  }

  login(){
    this.API = 'http://localhost:8080/login?'
    let username = this.userinputname;
    let password = this.userinputpassword;

    let user = 'username=' + username + '&' + 'password=' + password;

    let adress = this.API + user;

    console.log(adress);

    this.http.post(adress).map(res => res.json()).subscribe(
      data => {
        this.data = data;
        console.log(this.data);
      },
      err => {
        console.log('fuxk de funka inte');
      }
    );

    console.log('login pressed', username, password);
    this.navCtrl.push(HomePage);

  }

}
