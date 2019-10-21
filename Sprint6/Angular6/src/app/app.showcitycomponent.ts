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

constructor(private service:HmsService){

    console.log("In constructor");
}

deleteCity(i):any
{
 this.service.deleteHotel(this.cities[i].cityId).subscribe(()=>console.log());
}




}