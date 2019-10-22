import { Component, OnInit, OnChanges, OnDestroy } from "@angular/core";
import { HmsService } from './service/app.hmsservice'
import { Room } from './_model/app.room'
import { Hotel } from './_model/app.hotel'
import { City } from './_model/app.city'


@Component({
    selector: 'showhotel',
    templateUrl: 'app.showhotel.html'
})


export class ShowHotelComponent {
    modelCity: any = {};
    modelHotel: any = {};
    modelRoom: any = {};

    cityList: any[] = [];
    hotelList: any[] = [];
    roomList: any[] = [];
    cityId : any;
    constructor(private service: HmsService) {

        console.log("In constructor");
    }

    ngOnInit(): void {

        this.service.getCities().subscribe((cityListS: any[]) => this.cityList = cityListS);

    }


    onChangeCity(cityid): any {
        this.cityId = cityid;
        this.service.getHotels(cityid).subscribe((hotelListS: any[]) => this.hotelList = hotelListS);

    }


    updateHotel(hotelId): any {
        this.service.updateHotel(this.modelHotel, hotelId).subscribe((data) => console.log(data));

    }

    deleteHotel(hotelId): any {
        alert(hotelId);
        this.service.deleteHotel(hotelId).subscribe(() => console.log());
        this.service.getHotels(this.cityId).subscribe((hotelListS: any[]) => this.hotelList = hotelListS);
    }



}