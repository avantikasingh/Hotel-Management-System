import { Component, OnInit, OnChanges, OnDestroy } from "@angular/core";
import { HmsService } from './service/app.hmsservice'
import { Room } from './_model/app.room'
import { Hotel } from './_model/app.hotel'
import { City } from './_model/app.city'


@Component({
    selector: 'showroom',
    templateUrl: 'app.showroom.html'
})


export class ShowRoomComponent {

    modelRoom: any = {};

    cityList: any[] = [];
    hotelList: any[] = [];
    roomList: any[] = [];
    constructor(private service: HmsService) {


        console.log("In constructor");
    }
    ngOnInit(): void {

        this.service.getCities().subscribe((cityListS: any[]) => this.cityList = cityListS);

    }


    onChangeCity(cityId): any {
        this.service.getHotels(cityId).subscribe((hotelListS: any[]) => this.hotelList = hotelListS);

    }

    onChangeHotel(hotelId, cityId): any {
        this.service.getRooms(hotelId, cityId).subscribe((roomListS: any[]) => this.roomList = roomListS);

    }



    updateRoom(roomId): any {
        this.service.updateRoom(this.modelRoom, roomId).subscribe((data) => console.log(data));

    }

    deleteRoom(i): any {

        this.service.deleteRoom(this.roomList[i].roomId).subscribe(() => console.log());
    }



}