// import { NgModule, ErrorHandler } from '@angular/core';
// import { BrowserModule } from '@angular/platform-browser';
// import {HttpClientModule} from '@angular/common/http';
// import { SocketIoModule } from 'ng-socket-io';
// import { IonicModule } from '@ionic/angular';
// import { SplashScreen } from '@ionic-native/splash-screen/ngx';
// import { StatusBar } from '@ionic-native/status-bar/ngx';
// import { AppComponent } from './app.component';
// import { AppRoutingModule } from './app-routing.module';
// import { HomePage } from './home/home.page';
// import { MyApp } from './app.component';
// import { SocketsService } from './sockets.service';
// import { ImagesService } from './images.service';
// import { PreloaderService } from './preloader.service';
// import { config } from 'configurations/configuration';
// //import { config } from 'process';


// @NgModule({
//   declarations: [MyApp,
//     HomePage
//   ],
//   entryComponents: [MyApp,
//     HomePage],
//   imports: [BrowserModule,
//   HttpClientModule,
//   IonicModule.forRoot(MyApp),
//   SocketIoModule.forRoot(config.io),
//   AppRoutingModule
// ],
//   providers: [
//     StatusBar,
//     SplashScreen,
//     //{provide: ErrorHandler, useClass: IonicErrorHandler},
//     SocketsService,
//     ImagesService,
//     PreloaderService

//   ],
//   bootstrap: [AppComponent]
// })
// export class AppModule {}

import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { ErrorHandler, NgModule } from '@angular/core';
import { IonApp, IonicModule } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { SocketIoModule } from 'ng-socket-io';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';


import { AppComponent } from './app.component';
import { HomePage } from './home/home.page';
import { config } from 'configurations/configuration';
import { SocketsService } from './sockets.service';
import { ImagesService } from './images.service';
import { PreloaderService } from './preloader.service';

@NgModule({
  declarations: [
    AppComponent,
    HomePage
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    IonicModule.forRoot({mode: 'md'}),
    SocketIoModule.forRoot(config.io),
    AppRoutingModule
  ],
  bootstrap: [IonApp],
  entryComponents: [
    AppComponent,
    HomePage
  ],
  providers: [
    StatusBar,
    SplashScreen,
    SocketsService,
    ImagesService,
    {provide: ErrorHandler},
    PreloaderService
  ]
})
export class AppModule {}
