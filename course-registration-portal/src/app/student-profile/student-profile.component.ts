import { Component, OnInit } from '@angular/core';
import { CourseDetails } from '../course-details';
import { Router } from '@angular/router';
import {CourseServiceService} from '../course-service.service';
//import { StudentComponent } from './student/student.component';
import { StudentDetails } from '../student-details';

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent implements OnInit {
  sid : number;
  sname : string;
  courseDetails : CourseDetails [] = [];
  courselist : CourseDetails [] = [];


 constructor( private courseserviceService: CourseServiceService,public router: Router ) { }
//  single(){
//    this.courseserviceService.singleData(this.sid).subscribe((data1)=>{
//      let dLen: number = Object.keys(data1).length;
//         this.sname = data1.name;
//         //console.log(data[i].courses);
//         for(let j = 0; j< dLen ; j++){
//           length = this.courseDetails.push(new CourseDetails(data[i].courses[j].description,data[i].courses[j].id));
//           //console.log(data[i].courses[j].description);
//           //console.log(data[j].courses.id);
//         }  
   
//  });
// }


  drop( cid : number){
    this.courseserviceService.dropCourse(this.sid,cid).subscribe((data1)=>{
      location.reload();
      this.router.navigateByUrl('', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/profile']));
       //this.ngOnInit();
    })

  }

  enroll( cid : number){
    this.courseserviceService.enrollCourse(this.sid,cid).subscribe((data1)=>{
      location.reload();
       this.router.navigateByUrl('/profile', {skipLocationChange: true}).then(()=>
      this.router.navigate(['/profile']));
      //this.ngOnInit();
    })

  }
  ngOnInit() {
    let data  = JSON.parse(localStorage.getItem('rawData'));
    this.sid = parseInt(localStorage.getItem('id'));
    //this.single();
    for(let i = 0; i<data.length; i++){
      if(data[i].id === this.sid){
        this.sname = data[i].name;
        //console.log(data[i].courses);
        for(let j = 0; j< data[i].courses.length ; j++){
          length = this.courseDetails.push(new CourseDetails(data[i].courses[j].description,data[i].courses[j].id));
          //console.log(data[i].courses[j].description);
          //console.log(data[j].courses.id);
        }
      }
      
    }

    this.courseserviceService.fetchallcourse().subscribe((data1)=>{
      let dLen: number = Object.keys(data1).length;
      for(let i = 0 ; i<dLen ; i++){
        let flag = 0;
        for(let j = 0; j<this.courseDetails.length; j++){
          //console.log(this.courseDetails[j].name);
          //console.log(data1[i]);
          //console.log("lalala")
          if(data1[i].id === this.courseDetails[j].id){
            flag = 1;
            //console.log(data[i].id);
            //console.log(this.courseDetails[j].id);
          }
        }
        if(flag !== 1){
            length = this.courselist.push(new CourseDetails(data1[i].description,data[i].id));
          }
      }
    });
    
    //console.log(this.courseDetails[0]);
    console.log(this.courselist);

  }

}
