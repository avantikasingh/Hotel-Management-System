import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent }  from './app.component';
import { HttpClientModule} from '@angular/common/http'
import {FormsModule} from '@angular/forms'
import { Routes, RouterModule } from '@angular/router';
import { CityComponent } from './app.citycomponent';
import { HotelComponent } from './app.hotelcomponent';
import { RoomComponent } from './app.roomcomponent';
import { AboutUsComponent } from './app.aboutuscomponent';
import { ShowComponent } from './app.showroomcomponent';

const myroute:Routes=[
    {path:'', redirectTo: 'about', pathMatch:'full'},
    {path:'about', component:AboutUsComponent},
    {path:'addcity', component:CityComponent},
    {path:'showcity', component:ShowComponent},   
    {path:'addhotel', component:HotelComponent},
    {path:'showhotel', component:ShowComponent},
    {path:'addroom', component:RoomComponent},
    {path:'showroom', component:ShowComponent}
]
@NgModule({
    imports: [
        BrowserModule, FormsModule, HttpClientModule,
        RouterModule.forRoot(myroute)
        
    ],
    declarations: [
        AppComponent, AboutUsComponent,
        ShowComponent, CityComponent, HotelComponent, RoomComponent
		],
    providers: [ ],
    bootstrap: [AppComponent]
})

export class AppModule { }