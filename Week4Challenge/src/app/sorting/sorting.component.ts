import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-sorting',
  templateUrl: './sorting.component.html',
  styleUrls: ['./sorting.component.css']
})
export class SortingComponent implements OnInit {

  str: string;
  out: string;
  flag: number = 1;
  sendValues(): void {
    //this.arr = this.str.split(" "); 
    let arr = this.str.split(',').map(function(item) {
      return parseInt(item, 10);
  });
  this.out = "Sorted list: " + arr.sort(function(a, b){return a-b});
  console.log(arr.sort(function(a, b){return a-b}));  
  }


  constructor() { }

  ngOnInit() {
  }

}
