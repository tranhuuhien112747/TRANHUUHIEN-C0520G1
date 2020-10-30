import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular-piper';
  public dataInput:string = "Ha Noi mua nay lam nhung con mua";
  public dataArray:string[] = ["1","2","3"];
  public inputNumber:number = 12.345;
  public inputPercent:number = 1.2345;
  public money:number = 9.5;
  public today:Date = new Date();

}
