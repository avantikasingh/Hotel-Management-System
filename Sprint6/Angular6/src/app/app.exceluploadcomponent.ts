import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {FileUploader} from 'ng2-file-upload';
import {HttpClient} from '@angular/common/http';
 
@Component({
  selector: 'excelupload',
  templateUrl: 'app.excelupload.html',
  
})
export class ExcelUploadComponent  {

    title = 'Upload Multiple Files in Angular 4';

    constructor (private httpService: HttpClient) {  }
  
    myFiles:string [] = [];
    sMsg:string = '';
  
    ngOnInit () {  }
    getFileDetails (e) {
      //console.log (e.target.files);
      for (var i = 0; i < e.target.files.length; i++) { 
        this.myFiles.push(e.target.files[i]);
      }
    }
  
    uploadFiles () {
      const frmData = new FormData();
      
      for (var i = 0; i < this.myFiles.length; i++) { 
        frmData.append("file", this.myFiles[i]);
      }
      
      this.httpService.post('http://localhost:9088/admin/upload/city', frmData).subscribe(
        data => {
          // SHOW A MESSAGE RECEIVED FROM THE WEB API.
          this.sMsg = data as string;
          console.log (this.sMsg);
        }
        // ,
        // (err: HttpErrorResponse) => {
        //   console.log (err.message);    // Show error, if any.
        // }
      );
    }
  }
