import { Component , OnInit, OnChanges, OnDestroy } from "@angular/core";
import {ProductService} from './service/app.productservice'
import {Product}from './_model/app.product'


@Component({selector:'prod',
templateUrl:'app.product.html'})


export class ProductComponent {
    model:any = {};