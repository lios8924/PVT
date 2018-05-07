import { Component } from '@angular/core';
import { IonicPage, NavController, NavParams } from 'ionic-angular';

import { SignupPage } from '../signup/signup';
import { HomePage } from '../home/home';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { ElementRef, ViewChild } from '@angular/core';
import { URLSearchParams, RequestOptions } from '@angular/http';

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
  usernameinput: string;
  passwordinput: string;

  constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient) {

  }

  ionViewDidLoad() {
    console.log('ionViewDidLoad LoginPage');
  }

  signup(){
    this.navCtrl.push(SignupPage);
  }

  loginPost(){
      this.API = 'http://localhost:8080/login';
      //var headers = new Headers({'Content-Type': 'application/json'});
      //headers.append('Content-Type', 'application/json');
/*
      let searchParams = new URLSearchParams();
      searchParams.append('username', this.usernameinput);
      searchParams.append('password', this.passwordinput);
      let body = searchParams.toString();
*/
    var headers = new HttpHeaders();
    headers = headers.set("Accept", 'application/json');
    headers = headers.set('Content-Type', 'application/json' );
    //let options = new RequestOptions({ headers: headers });

    /*let postParams = {
        username: this.usernameinput,
        password: this.passwordinput
    };*/
/*
    this.http.post("http://jsonplaceholder.typicode.com/posts", postParams, options)
        .subscribe(data => {
            console.log(data['_body']);
        }, error => {
            console.log(error);// Error getting the data
     });
*/

      var body = JSON.stringify({
          username: this.usernameinput,
          password: this.passwordinput
      });

      console.log(this.API, body, headers);

      this.http.post(this.API, body, { headers: headers }).map(data => data).subscribe(
            data => {
                console.log(data);
                if(data == 0)
                    this.navCtrl.push(HomePage);
                else
                    console.log(data , "No existing user");
            },
            err => {
                console.log('helvete');
            }
        );

  }

//DENNA SKIT SKA BORT MEN LÅTER DEN STÅ KVAR SÅ LÄNGE BARA!
  login(){
    this.API = 'http://localhost:8080/login'

    let user = '?username=' + this.usernameinput + '&' + 'password=' + this.passwordinput;

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

    console.log('login pressed', this.usernameinput, this.passwordinput);
    this.navCtrl.push(HomePage);

  }

}
