import { BrowserModule } from '@angular/platform-browser';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonicApp, IonicErrorHandler, IonicModule } from 'ionic-angular';
import { SplashScreen } from '@ionic-native/splash-screen';
import { StatusBar } from '@ionic-native/status-bar';

import { Geolocation } from '@ionic-native/geolocation';
import { HttpClientModule } from '@angular/common/http';

import { MyApp } from './app.component';

import { HomePage } from '../pages/home/home';
import { LoginPage } from '../pages/login/login';
import { SignupPage } from '../pages/signup/signup';
import { LobbyPage } from '../pages/lobby/lobby';


import { ConfigProvider } from '../providers/config/config';
import { LampProvider } from '../providers/lamp/lamp';


@NgModule({
  declarations: [
    MyApp,
    LoginPage,
    SignupPage,
    LobbyPage,
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
    HomePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    Geolocation,
    ConfigProvider,
    LampProvider
  ]
})
export class AppModule {}
