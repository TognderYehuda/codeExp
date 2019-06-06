import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { FlexLayoutModule } from "@angular/flex-layout";
import {
  MatButtonModule,
  MatDividerModule,
  MatIconModule,
  MatMenuModule,
  MatProgressSpinnerModule,
  MatTableModule,
  MatToolbarModule
} from "@angular/material";
import { HttpClientModule } from "@angular/common/http";
import { FormsModule } from "@angular/forms";
import { ProductsComponent } from "./products/products.component";
import { HomeComponent } from "./home/home.component";
import { CommonModule } from "@angular/common";
import { OktaAuthModule } from "@okta/okta-angular";

@NgModule({
  declarations: [AppComponent, ProductsComponent, HomeComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FlexLayoutModule,
    MatToolbarModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    MatTableModule,
    MatDividerModule,
    MatProgressSpinnerModule,
    FormsModule,
    OktaAuthModule.initAuth({
      issuer: "https://dev-498044.okta.com/oauth2/default",
      redirectUri: "http://localhost:4200/implicit/callback",
      clientId: "0oaorhxki0QFJUDVB356"
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
