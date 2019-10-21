import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {HmsService} from './service/app.hmsservice'
import {Room}from './_model/app.room'
import {Hotel}from './_model/app.hotel'
import {City}from './_model/app.city'


@Component({selector:'showroom',
templateUrl:'app.showroom.html'})


export class ShowRoomComponent {

    modelRoom:any = {};


rooms:Room[]=[];
constructor(private service:HmsService){

    console.log("In constructor");
}



updateRoom(roomId):any
{
    this.service.updateRoom(this.modelRoom, roomId).subscribe((data)=>console.log(data));

}

deleteRoom(i):any
{

 this.service.deleteRoom(this.rooms[i].roomId).subscribe(()=>console.log());
}



}