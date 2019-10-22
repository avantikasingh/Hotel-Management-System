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
//     constructor(private myhttp:HttpClient){}
//     fileToUpload: File = null;
    // handleFileInput(files: FileList) {
    //     this.fileToUpload = files.item(0);
    //     let form=new FormData();
    //     // form.set.name();
    //     form.set("file" , this.fileToUpload);
    //     return this.myhttp.post('http://localhost:9088/admin/upload/city?', form);
    // }


//       postFile(fileToUpload: File): Observable<boolean> {
//         const endpoint = 'your-destination-url';
//         const formData: FormData = new FormData();
//         formData.append('fileKey', fileToUpload, fileToUpload.name);
//         return this.httpClient
//           .post(endpoint, formData, { headers: yourHeadersConfig })
//           .map(() => { return true; })
//           .catch((e) => this.handleError(e));
//     }
 
//   @ViewChild('fileInput') fileInput: ElementRef;
 
//   uploader: FileUploader;
//   isDropOver: boolean;
 
//   ngOnInit(): void {
//     let headers = new Headers();
//     headers.append('Content-Type', 'application/json');
//     headers.append('Access-Control-Allow-Credentials','true');

//     // const headers = [{name: 'Accept', value: 'application/json'},
// // {name: 'Access-Control-Allow-Credentials', value: 'true'}];
//     this.uploader = new FileUploader({url: 'http://localhost:9088/admin/upload/city', autoUpload: true, headers: headers});
 
//     this.uploader.onCompleteAll = () => alert('File uploaded');
//   }
 
//   fileOverAnother(e: any): void {
//     this.isDropOver = e;
//   }
 
//   fileClicked() {
//     this.fileInput.nativeElement.click();
//   }

// }
