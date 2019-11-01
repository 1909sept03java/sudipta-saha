import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { StudentDetails } from '../student-details';
import { StudentComponent } from './student.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BrowserDynamicTestingModule } from '@angular/platform-browser-dynamic/testing';
import { AppRoutingModule } from '../app-routing.module';
import { AppComponent } from '../app.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {MatListModule} from '@angular/material/list';
import { StudentProfileComponent } from '../student-profile/student-profile.component';
import {MatCardModule} from '@angular/material/card';
import { CourseDetails } from '../course-details';
import { Router } from '@angular/router';


//const sdetails: StudentDetails  = {'Niloy',1};
//  const sdetails: StudentDetails = {
   
//    name: 'Niloy',
//    id: 2
// };

const sdetails : StudentDetails [] = [new StudentDetails('Niloy',1)];
console.log(sdetails[0].id + ' test ' + sdetails[0].name);

//const cdetails: CourseDetails = new CourseDetails('Math',1);

describe('StudentComponent', () => {
  let component: StudentComponent;
  let fixture: ComponentFixture<StudentComponent>;
  let r: Router;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent,
        StudentComponent,
        StudentProfileComponent
      ],
      imports: [
        BrowserModule,
        MatCardModule,
        BrowserAnimationsModule,
        FormsModule,
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        MatListModule
      ]
    });
    TestBed.overrideModule(BrowserDynamicTestingModule, {
      set: {
        entryComponents: [StudentComponent] // cut out NgbModalBackdrop, NgbModalWindow,
      }
    }) 
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StudentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should match with the spyObj', () => {
    //component.ngOnDestroy();
    const bs = jasmine.createSpyObj('CourseServiceService', ['test']);
    bs.test.and.returnValue(sdetails[0].name);
    let com = new StudentComponent(bs,r);
    //component.ngOnInit();
    //expect(component.ngOnInit()).toEqual(1);
    //expect(component.studentDetails[0]).toEqual(1);
    console.log(com.testFun());
    expect(com.testFun()).toBe(sdetails[0].name);
    //console.log(component.studentDetails+ 'dfds');
  });

  


// it('should set studentDetails to [] false', () => {
//   component.ngOnDestroy();
//   if (component.studentDetails !== undefined) {
//     for (const student of component.studentDetails) {
//       const bs = jasmine.createSpyObj('CourseServiceService', ['fetchallstudent']);
//       expect(bs.fetchallstudent()).toBeFalsy();
//     }
//   }
// });

// it('should return False', () => {
//   expect(parseInt(localStorage.getItem('id'))).toBeFalsy();
// });

it('should return true', () => {
  expect(component.studentProfile(sdetails[0].id)).toBeTruthy();
});

it('Id is 1', () => {
  component.studentProfile(sdetails[0].id);
  expect(parseInt(localStorage.getItem('id'))).toEqual(1);
});

// it('Id is 1', () => {
//   component.studentProfile(sdetails.id);
//   expect(parseInt(localStorage.getItem('id'))).toEqual(2);
// });

});