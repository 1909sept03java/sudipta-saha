import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-palindrome',
  templateUrl: './palindrome.component.html',
  styleUrls: ['./palindrome.component.css']
})
export class PalindromeComponent implements OnInit {
  
  str: string;
  out: string;
  flag: number = 1;
  sendValues(): void {
    let length = this.str.length - 1;
    this.flag =1;
    for(let k=0; k<length/2; k++){
      if(this.str.charAt(k) != this.str.charAt(length)){
        this.out = "Not a Palindrome";
        console.log("Not a Palindrome");
        this.flag =0;
        break;
      }
      length --;
    }
    if(this.flag === 1){
      this.out = this.str + " is a Palindrome";
      console.log(this.str + " is a Palindrome");
    }
    
  }

  constructor() { }
  ngOnInit() {
  }

}
