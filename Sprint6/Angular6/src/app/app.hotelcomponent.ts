import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {HmsService} from './service/app.hmsservice'
import {Hotel}from './_model/app.hotel'


@Component({selector:'hotel',
templateUrl:'app.hotel.html'})


export class HotelComponent {
    modelHotel:any = {};

hotels:Hotel[]=[];
constructor(private service:HmsService){

    console.log("In constructor");
}



addHotel(cityId):any
{
    this.service.addHotel(this.modelHotel, cityId).subscribe((data)=>console.log(data));

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



// initiateUpdateProduct(inid):any
// {
//     this.prodUpdate = true;
//     for( var i = 0; i < this.products.length; i++){ 
//                 if (inid == this.products[i].prodId ) {
//                     this.prodName = this.products[i].prodName;
//                     this.prodPrice = this.products[i].prodPrice;
                  
//                 }
//              }
            
            
// }




// completeUpdateProduct(inid):any
// {
//     for( var i = 0; i < this.products.length; i++){ 
//         if (inid == this.products[i].prodId ) {
//             this.products[i].prodName= this.prodName ;
//             this.products[i].prodPrice= this.prodPrice;
//             this.prodUpdate = false;
//         }
//      }

    

// }

}