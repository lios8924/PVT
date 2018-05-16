import {Component} from '@angular/core';
import {IonicPage, NavController, NavParams, AlertController} from 'ionic-angular';

import {SignupPage} from '../signup/signup';
import {HomePage} from '../home/home';
import {LobbyPage} from '../lobby/lobby';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import 'rxjs/add/operator/map';
import {ElementRef, ViewChild} from '@angular/core';
import {URLSearchParams, RequestOptions} from '@angular/http';



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

    API: any;
    data: any;
    usernameinput: string;
    passwordinput: string;


    constructor(public navCtrl: NavController, public navParams: NavParams, public http: HttpClient, public alertCtrl: AlertController) {

    }

    ionViewDidLoad() {
        console.log('ionViewDidLoad LoginPage');
    }

    signup() {
        this.navCtrl.push(SignupPage);
    }




    loginPost() {
        this.API = 'http://localhost:8080/login';

        var headers = new HttpHeaders();
        headers = headers.set("Accept", 'application/json');
        headers = headers.set('Content-Type', 'application/json');

        var body = JSON.stringify({
            username: this.usernameinput,
            password: this.passwordinput
        });

        console.log(this.API, body, headers);


        /**/
        if(true){
        localStorage.setItem('username', this.usernameinput);
        localStorage.setItem('loggedIn', 'true');

        this.navCtrl.push(LobbyPage);
      }
        //////

        this.http.post(this.API, body, {headers: headers}).map(data => data).subscribe(
            data => {
                console.log(data);
                if (data == 0) {

                    localStorage.setItem('username', this.usernameinput);
                    localStorage.setItem('loggedIn', 'true');

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
                console.log('helvete');
            }
        ); 

    }

}
