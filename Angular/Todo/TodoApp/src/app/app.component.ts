import { Component, OnInit } from "@angular/core";
import { OktaAuthService } from "@okta/okta-angular";

@Component({
  selector: "app-root",
  templateUrl: "./app.component.html",
  styleUrls: ["./app.component.css"]
})
export class AppComponent implements OnInit {
  title = "TodoApp";
  public isAuthenticated: boolean;

  constructor(public oktaAuth: OktaAuthService) {
    this.oktaAuth.$authenticationState.subscribe(
      (isAuthenticated: boolean) => (this.isAuthenticated = isAuthenticated)
    );
    this.isAuthenticated = false;
  }

  login() {
    this.oktaAuth.loginRedirect();
  }
  logout() {
    this.oktaAuth.logout("/");
  }

  async ngOnInit() {
    this.isAuthenticated = await this.oktaAuth.isAuthenticated();
  }
}
