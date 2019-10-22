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
    
    modelHotel: any = {};
    update= false;

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


   

    deleteHotel(hotelId): any {
        alert(hotelId);
        this.service.deleteHotel(hotelId).subscribe(() => console.log());
        this.hotelList = [];
        this.service.getHotels(this.cityId).subscribe((hotelListS: any[]) => this.hotelList = hotelListS);
    }

    updateHotel(): any {
        this.service.updateHotel(this.modelHotel, this.modelHotel.hotelId).subscribe((data) => console.log(data));
        this.update = false;


    }

    



    initiateUpdateHotel(inid): any {
        this.update = true;
        for (var i = 0; i < this.hotelList.length; i++) {
            if (inid == this.hotelList[i].hotelId) {
                this.modelHotel.hotelId = this.hotelList[i].hotelId;
                this.modelHotel.hotelName = this.hotelList[i].hotelName;
                this.modelHotel.hotelAddress = this.hotelList[i].hotelAddress;
                this.modelHotel.hotelPhoneNumber = this.hotelList[i].hotelPhoneNumber;
                this.modelHotel.hotelRating = this.hotelList[i].hotelRating;
                

            }
        }



}