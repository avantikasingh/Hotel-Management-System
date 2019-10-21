import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {HmsService} from './service/app.hmsservice'
import {Room}from './_model/app.room'
import {Hotel}from './_model/app.hotel'
import {City}from './_model/app.city'


@Component({selector:'show',
templateUrl:'app.show.html'})


export class ShowComponent {
    modelCity:any = {};
    modelHotel:any = {};
    modelRoom:any = {};

cities:City[]=[];
hotels:Hotel[]=[];
rooms:Room[]=[];
constructor(private service:HmsService){

    console.log("In constructor");
}



updateHotel(hotelId):any
{
    this.service.updateHotel(this.modelHotel, hotelId).subscribe((data)=>console.log(data));

}

deleteHotel(i):any
{
alert(this.hotels[i].hotelId);
 this.service.deleteHotel(this.hotels[i].hotelId).subscribe(()=>console.log());
}



}