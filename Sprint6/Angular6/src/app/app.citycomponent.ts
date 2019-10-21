import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {HmsService} from './service/app.hmsservice'
import {City}from './_model/app.city'


@Component({selector:'city',
templateUrl:'app.city.html'})


export class CityComponent {
    modelCity:any = {};
constructor(private service:HmsService){

    console.log("In constructor");
}


addCity():any
{
    alert(this.modelCity.cityName);
    this.service.addCity(this.modelCity).subscribe((data)=>console.log(data));

}



}

