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
    update = false;

    rName: any;
    rType: any;
    rRent: any;

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



    updateRoom(): any {
        this.service.updateRoom(this.modelRoom, this.modelRoom.roomId).subscribe((data) => console.log(data));
        this.update = false;


    }

    deleteRoom(i): any {

        this.service.deleteRoom(i).subscribe(() => console.log());
    }




    initiateUpdateRoom(inid): any {
        this.update = true;
        for (var i = 0; i < this.roomList.length; i++) {
            if (inid == this.roomList[i].roomId) {
                this.modelRoom.roomId = this.roomList[i].roomId;
                this.modelRoom.roomType = this.roomList[i].roomType;
                this.modelRoom.roomRent = this.roomList[i].roomRent;
                this.modelRoom.roomNumber = this.roomList[i].roomNumber;
                
                

            }
        }


    }






}