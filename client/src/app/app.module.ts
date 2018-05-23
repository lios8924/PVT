import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';
import { NFC, Ndef } from '@ionic-native/nfc';

import { Geolocation } from '@ionic-native/geolocation';
import { HttpClientModule } from '@angular/common/http';

import { MyApp } from './app.component';
import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { SignupPage } from '../pages/signup/signup';
import { EndPage } from '../pages/end/end';

import { LobbyPage } from '../pages/lobby/lobby';
import { ConfigProvider } from '../providers/config/config';
import { LampProvider } from '../providers/lamp/lamp';
import { SocialSharing } from '@ionic-native/social-sharing';
import { ProflieProvider } from '../providers/proflie/proflie';
import { LampMarkers } from '../assets/ts/LampMarkers';
import { nfcComponent } from '../assets/ts/nfcComponent';


@NgModule({
  declarations: [
    MyApp,
    LoginPage,
    SignupPage,
    LobbyPage,
    EndPage,
    HomePage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    IonicModule.forRoot(MyApp)
  ],
  bootstrap: [IonicApp],
  entryComponents: [
    MyApp,
    LoginPage,
    SignupPage,
    LobbyPage,
    EndPage,
    HomePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    Geolocation,
    ConfigProvider,
    LampProvider,
    SocialSharing,
    ProflieProvider,
    LampMarkers,
    NFC,
    Ndef,
    nfcComponent
  ]
})
export class AppModule {}
