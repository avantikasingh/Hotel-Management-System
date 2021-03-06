﻿import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from '@angular/forms'
import { Routes, RouterModule } from '@angular/router';
import { CityComponent } from './app.citycomponent';
import { HotelComponent } from './app.hotelcomponent';
import { RoomComponent } from './app.roomcomponent';
import { AboutUsComponent } from './app.aboutuscomponent';
import { ShowCityComponent } from './app.showcitycomponent';
import { ShowHotelComponent } from './app.showhotelcomponent';
import { ShowRoomComponent } from './app.showroomcomponent';
import { ExcelUploadComponent } from './app.exceluploadcomponent';
import { RegisterComponent } from './app.registercomponent';
import {FileUploadModule} from 'ng2-file-upload';



const myroute: Routes = [
    { path: '', redirectTo: 'about', pathMatch: 'full' },
    { path: 'about', component: AboutUsComponent },
    { path: 'addcity', component: CityComponent },
    { path: 'showcity', component: ShowCityComponent },
    { path: 'addhotel', component: HotelComponent },
    { path: 'showhotel', component: ShowHotelComponent },
    { path: 'addroom', component: RoomComponent },
    { path: 'showroom', component: ShowRoomComponent },
    { path: 'excelupload', component: ExcelUploadComponent },
    { path: 'register', component: RegisterComponent }
]
@NgModule({
    imports: [
        BrowserModule, FormsModule, HttpClientModule,FileUploadModule,
        RouterModule.forRoot(myroute)

    ],
    declarations: [
        AppComponent, AboutUsComponent, ShowCityComponent, ShowHotelComponent, ExcelUploadComponent,
        ShowRoomComponent, CityComponent, HotelComponent, RoomComponent, RegisterComponent
    ],
    providers: [],
    bootstrap: [AppComponent]
})

export class AppModule { }