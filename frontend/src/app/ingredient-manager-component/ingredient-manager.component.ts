import { Component, OnInit } from '@angular/core';
import {Ingredient} from "../ingredient";
import {IngredientService} from "../ingredient.service";

@Component({
  selector: 'app-ingredient-manager-component',
  templateUrl: './ingredient-manager.component.html',
  styleUrls: ['./ingredient-manager.component.sass']
})
export class IngredientManagerComponent implements OnInit {

  ingredients: Ingredient[] = [ ];

  constructor(private ingredientService: IngredientService) { }

  ngOnInit(): void {
    this.getAllIngredients();
  }

  getAllIngredients() {
    this.ingredientService.getAll()
      .subscribe((ingredients: Ingredient[]) => {
        this.ingredients = ingredients;
      });
  }

}
