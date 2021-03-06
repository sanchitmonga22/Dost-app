// import { Injectable } from '@angular/core';

// @Injectable({
//   providedIn: 'root'
// })
// export class SocketsService {

//   constructor() { }
// }

import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Socket } from 'ng-socket-io';
import { Observable } from 'rxjs';

@Injectable()
export class SocketsService {


   /**
    * @name _SERVER
    * @type object
    * @private
    * @description              The URI where the Socket.io server is running
    */
   private _SERVER 	=	'REMOTE-ADDRESS-OF-NODE-SERVER';

   constructor(public http: HttpClient, private _SOCKET: Socket) {  }

   /**
    * @public
    * @method pollServer
    * @description    			Use Angular Http call to determine if server address is reachable
    * @return {Observable}
    */
   pollServer(): Observable<any> {
      return this.http.get(this._SERVER);
   }

   /**
    * @public
    * @method registerForChatService
    * @param alias  	{string}     	The user's screen name alias
    * @param handle  	{string}     	The user's tagline
    * @param location	{string}     	The user's location
    * @description    					Register's the user with the current Socket.io chat session
    * @return {none}
    */
   registerForChatService(alias: string, handle: string, location: string): void {
      this._SOCKET.connect();
      this._SOCKET.emit('set-alias', {
        alias, handle, location
      });
   }

   /**
    * @public
    * @method retrieveMessages
    * @description    					Retrieves the messages currently active in the session
    * @return {Observable}
    */
   retrieveMessages(): Observable<any> {// might be an error here
      return new Observable((observer) => {
         this._SOCKET.on('message', (data: unknown) => {
            observer.next(data);
         });
      });
   }

   /**
    * @public
    * @method addMessage
    * @description    					Adds a message to the socket.io session
    * @return {none}
    */
   addMessage(message: string): void {
      // Use the emit method of the Socket.io library to broadcast a custom event
      // ('add-message') to the service - this will then add the supplied data to
      // the current session message stream
      this._SOCKET.emit('add-message', { message });
   }

   /**
    * @public
    * @method addImage
    * @description    					Adds an image to the socket.io session
    * @return {none}
    */
   addImage(image: string): void {
      // Use the emit method of the Socket.io library to broadcast a custom event
      // ('add-image') to the service - this will then add the supplied data to
      // the current session message stream
      this._SOCKET.emit('add-image', { image });
   }

   /**
    * @public
    * @method logOut
    * @description    					Closes the current user's socket.io session
    * @return {none}
    */
   logOut(): void {
      this._SOCKET.disconnect();
   }
}