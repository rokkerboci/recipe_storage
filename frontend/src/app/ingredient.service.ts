import {Injectable, Injector} from '@angular/core';
import {RestService} from "@lagoshny/ngx-hal-client";
import {Ingredient} from "./ingredient";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class IngredientService extends RestService<Ingredient> {

  constructor(injector: Injector) {
    super(Ingredient, 'ingredients', injector);
  }

  public findByName(name: string): Observable<Ingredient[]> {
    let options: any = {params: [{key: 'name', value: name}]};
    return this.search('findByName', options);
  }

}
