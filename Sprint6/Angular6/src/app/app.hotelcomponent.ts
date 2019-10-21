import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {HmsService} from './service/app.hmsservice'
import {Hotel}from './_model/app.hotel'


@Component({selector:'hotel',
templateUrl:'app.hotel.html'})


export class HotelComponent {
    modelHotel:any = {};
    

constructor(private service:HmsService){

    console.log("In Hotel constructor");
}


getcities(){

}

addHotel(cityId):any
{
    this.service.addHotel(this.modelHotel, cityId).subscribe((data)=>console.log(data));

}




}