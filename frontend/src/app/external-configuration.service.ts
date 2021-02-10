import { Injectable } from '@angular/core';
import {ExternalConfiguration, ExternalConfigurationHandlerInterface} from "@lagoshny/ngx-hal-client";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ExternalConfigurationService implements ExternalConfigurationHandlerInterface {

  getProxyUri(): string {
    return '/api';
  }

  getRootUri(): string {
    return '/api';
  }

  getHttp(): HttpClient {
    return this.http;
  }

  constructor(private http: HttpClient) {
  }

  deserialize() {
      throw new Error('Method not implemented.');
  }
  serialize() {
      throw new Error('Method not implemented.');
  }

  getExternalConfiguration(): ExternalConfiguration {
    // @ts-ignore
    return null;
  }

  setExternalConfiguration(externalConfiguration: ExternalConfiguration) {
  }

}
