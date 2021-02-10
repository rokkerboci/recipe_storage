import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgxHalClientModule} from "@lagoshny/ngx-hal-client";
import {ExternalConfigurationService} from "./external-configuration.service";
import { IngredientManagerComponent } from './ingredient-manager-component/ingredient-manager.component';
import {MatListModule} from "@angular/material/list";

@NgModule({
  declarations: [
    AppComponent,
    IngredientManagerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgxHalClientModule.forRoot(),
    MatListModule
  ],
  providers: [
    {provide: 'ExternalConfigurationService', useClass: ExternalConfigurationService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
