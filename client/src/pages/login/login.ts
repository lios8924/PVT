import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import {SignupPage} from '../signup/signup';
import {HomePage} from '../home/home';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import {ElementRef, ViewChild} from '@angular/core';

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
  username: any;
  password: any;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

  signup(){
    this.navCtrl.push(SignupPage)
  }

  login(){
    this.API = 'http://localhost:8080/login'

    //username = this.userinputname;
    //password = this.userinputpassword;

    this.username = (<HTMLInputElement>document.getElementById('nameinput')).value;
    this.password = (<HTMLInputElement>document.getElementById('passinput')).value;


    let user = '?username=' + this.username + '&' + 'password=' + this.password;

    let adress = this.API + user;

    console.log(adress);

    this.http.get(this.API).subscribe(
      data => {
        this.data = data;
        console.log(this.data);
      },
      err => {
        console.log('fuxk de funka inte');
      }
    );

    console.log('login pressed', this.username, this.password);
    this.navCtrl.push(HomePage);

  }

}
