import { Component } from "@angular/core";
import {HmsService} from './service/app.hmsservice';
import { Customer } from "./_model/app.customer";

@Component({selector:'register',
templateUrl:'app.register.html'})


export class RegisterComponent {
    customer:any = {};

customers:Customer[]=[];
constructor(private service:HmsService){
    console.log("In constructor");
}

}