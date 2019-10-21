import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {HmsService} from './service/app.hmsservice'
import {Room}from './_model/app.room'


@Component({selector:'room',
templateUrl:'app.room.html'})


export class RoomComponent {

modelRoom:any = {};
    
cityList:any[]=[];
hotelList:any[]=[];


constructor(private service:HmsService){

    console.log("In Room constructor");
}
ngOnInit(): void {

    this.service.getCities().subscribe((cityListS:any[]) => this.cityList = cityListS);
    
    console.log(this.cityList);
}
onChange(cityId):any{
    this.service.getHotels(cityId).subscribe((hotelListS:any[]) => this.hotelList = hotelListS);
    
}




addRoom(cityId, hotelId):any
{
    this.service.addRoom(this.modelRoom, cityId, hotelId).subscribe((data)=>console.log(data));
}



}