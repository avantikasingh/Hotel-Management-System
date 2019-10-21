import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
    providedIn: 'root'

})
export class HmsService {
    constructor(private myhttp: HttpClient) {
    }



    addCity(data: any) {
        alert("in service");
        return this.myhttp.post("http://localhost:9088/admin/cities", data);
    }

    deleteCity(data: any) {
        return this.myhttp.post("http://localhost:9088/admin/cities", data);
    }

    getCities() {
        return this.myhttp.get("http://localhost:9088/admin/cities");
    }



    addHotel(data: any, cityId: any) {
        return this.myhttp.post("http://localhost:9088/admin/hotels?cityId=" + cityId, data);
    }

    updateHotel(data: any, hotelId: any) {
        return this.myhttp.put("http://localhost:9088/admin/hotels?hotelId=" + hotelId, data);
    }

    deleteHotel(hotelId: any) {
        return this.myhttp.delete("http://localhost:9088/admin/hotels/" + hotelId);
    }

    getHotels(cityId) {
        return this.myhttp.get("http://localhost:9088/admin/hotels/" + cityId);
    }



    addRoom(data: any, cityId: any, hotelId: any) {
        return this.myhttp.post("http://localhost:9088/admin/rooms?cityId=" + cityId + "&hotelId=" + hotelId, data);
    }

    updateRoom(data: any, roomId: any) {
        return this.myhttp.put("http://localhost:9088/admin/rooms?roomId=" + roomId, data);
    }


    deleteRoom(roomId: any) {
        return this.myhttp.delete("http://localhost:9088/admin/rooms/" + roomId);
    }

    getRooms(hotelId, cityId) {
        return this.myhttp.get("http://localhost:9088/admin/rooms?cityId=" + cityId + "&hotelId=" + hotelId);
    }








    getAllData() {
        return this.myhttp.get("http://localhost:9088/product/getall");
    }

    addProduct(data: any) {

        let form = new FormData();
        form.append("prodId", data.prodId);
        form.append("prodName", data.prodName);
        form.append("prodCost", data.prodCost);
        form.append("prodDescription", data.prodDescription);
        // return this.myhttp.post("http://192.168.0.161:9088/product/add", data);
        return this.myhttp.post("http://localhost:9088/product/add", form);
    }
    deleteProduct(i) {

        return this.myhttp.delete("http://localhost:9088/product/delete?id=" + i);
    }
}