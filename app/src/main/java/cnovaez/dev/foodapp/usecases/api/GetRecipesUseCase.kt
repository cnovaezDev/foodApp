package cnovaez.dev.foodapp.usecases.api

import cnovaez.dev.foodapp.data.repositories.FoodRepository
import cnovaez.dev.foodapp.domain.models.network.RecipeBodyClass
import cnovaez.dev.foodapp.domain.models.network.api_response.Recipe
import cnovaez.dev.foodapp.utils.logError
import cnovaez.dev.foodapp.utils.logInformation
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 01/01/2023 14:37
 ** cnovaez.dev@outlook.com
 **/
class GetRecipesUseCase @Inject constructor(private val foodRepository: FoodRepository) {

//    suspend operator fun invoke(recipeBodyClass: RecipeBodyClass) =
//        foodRepository.getRecipes(recipeBodyClass)

    suspend operator fun invoke(): List<Recipe> {
        val list: MutableList<Recipe> = mutableListOf()
        val response = foodRepository.getRecipes()
        logInformation("API Response: ${response}")
        try {
            if (response != null && response.isSuccessful) {
                val jsonData = Gson().toJson(response.body())
                val jsonCatalogRecipes = JSONObject(jsonData)
                val jsonRecipes: JSONArray = jsonCatalogRecipes.getJSONArray("hits")

                for (i in 0 until jsonRecipes.length()) {
                    val recipe: Recipe = Recipe()
                    val jsonObject: JSONObject = jsonRecipes.getJSONObject(i)
                    //  val value = jsonObject.getJSONArray("value")
                    // val currObj = value.getJSONObject(i)
                    val currentRecipe = jsonObject.getJSONObject("recipe")
                    // val currentRecipeVal = currentRecipe.getJSONObject("value")
                    recipe.label = currentRecipe.getString("label")
                    recipe.image = currentRecipe.getString("image")
                    recipe.url = currentRecipe.getString("url")
                    recipe.calories = currentRecipe.getInt("calories")
                    recipe.yield = currentRecipe.getInt("yield")
                    recipe.url = currentRecipe.getString("url")

//                    val instructions: MutableList<String> = mutableListOf()
//                    val instructionsList: JSONArray = currentRecipe.getJSONArray("instructions")
//
//                    for (x in 0 until instructionsList.length()) {
//                        instructions.add(instructionsList.get(x).toString())
//                    }

                    val ingredients: MutableList<String> = mutableListOf()
                    val ingredientsList: JSONArray = currentRecipe.getJSONArray("ingredientLines")

                    for (j in 0 until ingredientsList.length()) {
                        ingredients.add(ingredientsList.get(j).toString())
                    }

                  //  recipe.instructions = instructions as ArrayList<String>
                    recipe.ingredientLines = ingredients as ArrayList<String>
                    list.add(recipe)
                }
            }
        } catch (ex: Exception) {
            logError("Error in getRecipeUseCase invoke(): ${ex.message.toString()}")
        }
        return list
    }
    // suspend operator fun invoke(bool: Boolean) = foodRepository.getRecipes2()

}