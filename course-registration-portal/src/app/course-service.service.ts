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
  allcourse = 'http://localhost:8083/course/all';
  drop = 'http://localhost:8083/student/drop?';
  enroll = 'http://localhost:8083/student/enroll?';
  single = 'http://localhost:8083/student/';
  //localhost:8083/student/drop?sid=2&cid=2




  constructor(private httpClient: HttpClient) { }
  public singleData(sid : number){
    return this.httpClient.get(this.single+sid);

  }

  public enrollCourse(sid : number, cid :number){
     return this.httpClient.get(this.enroll+'sid='+sid+'&'+'cid='+cid);
   }
   public dropCourse(sid : number, cid :number){
     return this.httpClient.get(this.drop+'sid='+sid+'&'+'cid='+cid);
   }

   public fetchallstudent() {
    return this.httpClient.get(this.allstudent);

  }
  
  public fetchallcourse() {
    return this.httpClient.get(this.allcourse);

  }

  public fetchsinglestudent( id : number) {

    return this.httpClient.get(this.singlestudent+id);

  }

}
