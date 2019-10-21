import { Component, OnInit, OnChanges, OnDestroy } from "@angular/core";
import { HmsService } from './service/app.hmsservice'
import { Room } from './_model/app.room'
import { Hotel } from './_model/app.hotel'
import { City } from './_model/app.city'


@Component({
    selector: 'showcity',
    templateUrl: 'app.showcity.html'
})


export class ShowCityComponent {
    modelCity: any = {};
    modelHotel: any = {};
    modelRoom: any = {};




    cityList: any[] = [];



    ngOnInit(): void {

        this.service.getCities().subscribe((cityListS: any[]) => this.cityList = cityListS);
        console.log(this.cityList);
    }

    constructor(private service: HmsService) {

        console.log("In constructor");
    }

    deleteCity(cityId): any {
        this.service.deleteHotel(cityId).subscribe(() => console.log());
    }




}