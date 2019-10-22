import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { identifierModuleUrl } from '@angular/compiler';

@Injectable({
  providedIn: 'root'
})
export class CourseServiceService {

  httpOptions = {
    headers: new HttpHeaders({ 
      "Content-Type": "application/json",
      'Access-Control-Allow-Origin':'*'
    })
  };

  allstudent = 'http://localhost:8083/student/all';
  singlestudent = 'http://localhost:8083/student/';

   constructor(private httpClient: HttpClient) { }

   public fetchallstudent() {
    return this.httpClient.get(this.allstudent);

  }

  public fetchsinglestudent( id : number) {

    return this.httpClient.get(this.singlestudent+id);

  }

}
