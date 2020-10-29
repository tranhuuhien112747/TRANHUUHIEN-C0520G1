import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { FontSizeComponent } from './font-size/font-size.component';
import { SelectColorComponent } from './select-color/select-color.component';
import { PetComponent} from './pet/pet.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    FontSizeComponent,
    SelectColorComponent,
    PetComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
