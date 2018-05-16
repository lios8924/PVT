import { Component } from '@angular/core';
import {AlertController, IonicPage, NavController, NavParams} from 'ionic-angular';
import {LoginPage} from '../login/login';

import 'rxjs/add/operator/map';
import { ElementRef, ViewChild } from '@angular/core';


import { HttpClient, HttpHeaders } from '@angular/common/http';
import { URLSearchParams, RequestOptions } from '@angular/http';

/**
 * Generated class for the SignupPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-signup',
  templateUrl: 'signup.html',
})
export class SignupPage {

    API: any;
    data: any;
    usernameinput: string;
    passwordinput: string;

    constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient, public alertCtrl: AlertController) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad SignupPage');
    }

    //Funkar, men 0 säkerhet
    signup(){

        this.API = 'http://localhost:8080/signup';

        var headers = new HttpHeaders();
        headers = headers.set("Accept", 'application/json');
        headers = headers.set('Content-Type', 'application/json' );


        var body = JSON.stringify({
            username: this.usernameinput,
            password: this.passwordinput
        });

        //console.log(this.API, body, headers);

        this.http.post(this.API, body, { headers: headers }).map(data => data).subscribe(
              data => {
                  console.log(data);
                  if(data == 0){
                      console.log("User ", this.usernameinput, " added successfully");
                      this.navCtrl.pop();
                  }
                  else{
                      let alert = this.alertCtrl.create({
                          title: 'User with that name already exist!',
                          buttons: ['Dismiss']
                      });
                      alert.present();
                      console.log(data , "User already exist!");
                  }
              },
              err => {
                  console.log('helvete');
              }
          );

    }

    goBack(){
        this.navCtrl.pop();
    }

}
