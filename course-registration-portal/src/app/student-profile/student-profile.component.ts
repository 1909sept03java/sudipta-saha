import { Component, OnInit } from '@angular/core';
import { CourseDetails } from '../course-details';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {
  sid : number;
  sname : string;
  courseDetails : CourseDetails [] = [];


  constructor() { }

  ngOnInit() {
    let data  = JSON.parse(localStorage.getItem('rawData'));
    this.sid = parseInt(localStorage.getItem('id'));
    for(let i = 0; i<data.length; i++){
      if(data[i].id === this.sid){
        this.sname = data[i].name;
        //console.log(data[i].courses);
        for(let j = 0; j< data[i].courses.length ; j++){
          length = this.courseDetails.push(new CourseDetails(data[i].courses[j].description,data[i].courses[j].id));
          console.log(data[i].courses[j].description);
          //console.log(data[j].courses.id);
        }
      }
      
    }
    
    console.log(this.courseDetails);
  }

}
