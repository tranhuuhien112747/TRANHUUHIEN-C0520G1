import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {ProfileComponent} from './profile/profile.component';
import { YComponent} from './calculator/y/y.component';
import { TinhtoanComponent} from './calculator/tinhtoan/tinhtoan.component';

@NgModule({
  declarations: [
    AppComponent,
    ProfileComponent,
    YComponent,
    TinhtoanComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
