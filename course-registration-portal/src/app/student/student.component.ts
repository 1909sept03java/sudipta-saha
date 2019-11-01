import { Component, OnInit, OnDestroy } from '@angular/core';
import { Router } from '@angular/router';
import {CourseServiceService} from '../course-service.service';
import { StudentDetails } from '../student-details';
import { Subscription } from 'rxjs';
import {MatListModule} from '@angular/material/list';


@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit, OnDestroy {

  studentDetails : StudentDetails [] = [];
  subscriptions: Subscription[] = [];
 // id : number;
 // name : string;


  constructor( private courseserviceService: CourseServiceService,public router: Router ) { }

  studentProfile(id : number) : boolean{
    localStorage.setItem('id',JSON.stringify(id));
    console.log(id);
    return true;
  }

  testFun(){
    return this.courseserviceService.test();
  }

  ngOnInit() {
    this.courseserviceService.fetchallstudent().subscribe((data)=>{
      localStorage.setItem('rawData',JSON.stringify(data));
      let lala  = JSON.parse(localStorage.getItem('rawData'));
      console.log(lala);
      let dLen: number = Object.keys(data).length;
      for(let i = 0; i<dLen; i++){
        length = this.studentDetails.push(new StudentDetails(data[i].name,data[i].id));
      }
      console.log(this.studentDetails);
      
    })
    //return this.studentDetails[0].id;
  }

  ngOnDestroy() {
    this.subscriptions.forEach(s => s.unsubscribe);
  }

}
