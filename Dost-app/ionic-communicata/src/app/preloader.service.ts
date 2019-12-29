// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class PreloaderService {
//    displayPreloader(arg0: string) {
//       throw new Error("Method not implemented.");
//    }
//    hidePreloader() {
//       throw new Error("Method not implemented.");
//    }

//   constructor() { }
// }

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoadingController } from '@ionic/angular';


@Injectable()
export class PreloaderService {
   /**
    * Reference for storing loading bar object
    */
   private loading: any;

   constructor( public http: HttpClient,
                public loadingCtrl: LoadingController) {
                  }
   /**
    *
    * Display an animated loading bar
    *
    * @public
    * @method displayPreloader
    * @param message    {String}        Message to be displayed with the loading bar
    * @return {none}
    */
   displayPreloader(message: string): void {
      this.loading = this.loadingCtrl.create({
      //  content: message
      });

      this.loading.present();
   }
   /**
    *
    * Hide animated loading bar
    *
    * @public
    * @method hidePreloader
    * @return {none}
    */
   hidePreloader(): void {
      this.loading.dismiss();
   }

}