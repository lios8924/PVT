import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';
import {LoginPage} from '../login/login';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
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
  apiUrl = 'http://localhost:8080';

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient) {
  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad SignupPage');
  }

  signup(){
    var data = "";
    this.http.post(this.apiUrl+'/registerUser', JSON.stringify(data), {
      params: new HttpParams().set('username', 'Agaton').set('password', 'saxar').set('email', 'detektiv@sax.se'),
    })
      .subscribe(res => {
        console.log(res);
      }, (err) => {
        console.log(err);
      });


    this.navCtrl.push(LoginPage)
  }

}
