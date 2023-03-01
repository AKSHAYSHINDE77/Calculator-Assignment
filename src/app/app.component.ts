import { Component , OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { CalServiceService } from './cal-service.service';
import { Calculator } from './calculator';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  title = 'Standard Calculator';

  calculator = new Calculator();
  nums: any;
  nu: any;
  msg = '';
  check = true;
  s = '';
  si = '';
  n: any;
  r = 0;
  resp2: any;
  constructor(private calService:CalServiceService, private router:Router) { }

  ngOnInit() {
  }


  public getString(v: string) {
    console.log(v);
    if (this.check) {
      this.s = v;
      this.check = false;
    } else {
      this.s === '0' ? (this.s = v) : (this.s += v);
    }
  }
  public getSign(s: string) {
    this.si = s;
  }

  public CC() {
    this.s = '';
    this.n = null;
  }

  public CE() {
    this.s.slice(this.s.length - 1);
  }

  public back() {
    this.s = this.s.slice(0, -1);
  }

  Calculations(value: any) {
    this.calculator.inserted = this.s;
    this.calculator.sign = this.si;
    this.calService.add(this.calculator).subscribe(
      (data) => {
        this.s = '';
        this.n = data.result;
        this.nu = data;
        console.log('response received');
        this.router.navigate(['/AppComponent']);
      },
      (error) => {
        console.log('exception occured');
        this.msg = 'Enter valid numbers!';
      }
    );
  }

  rrr(value: any) {
    this.calService.drop(this.calculator).subscribe(
      (data) => {
        console.log('response received');
        this.router.navigate(['/AppComponent']);
      },
      (error) => {
        console.log('exception occured');
        this.msg = 'Invalid numbers';
      }
    );
  }

  
}
