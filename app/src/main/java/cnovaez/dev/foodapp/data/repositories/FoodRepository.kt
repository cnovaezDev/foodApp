package cnovaez.dev.foodapp.data.repositories

import androidx.lifecycle.LiveData
import cnovaez.dev.foodapp.data.network.RetrofitAPI
import cnovaez.dev.foodapp.domain.models.network.Recipe
import cnovaez.dev.foodapp.utils.data_types.Mealtype
import cnovaez.dev.foodapp.utils.logError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 01/01/2023 12:32
 ** cnovaez.dev@outlook.com
 **/

class FoodRepository @Inject constructor(val retrofitAPI: RetrofitAPI) {


    private suspend fun getAllRecipesApi(recipe: Recipe): LiveData<List<Recipe>> {
        return retrofitAPI.getAllRecipesThatMatchQuery(recipe.query)
    }

    suspend fun getRecipes(recipe: Recipe, forceUpdate: Boolean = false): LiveData<List<Recipe>>? {
        return try {
            getAllRecipesApi(recipe)
            //Insertar en la base de datos
        } catch (ex: Exception) {
            ex.message?.let { logError(it) }
            null
        }
    }

    suspend fun getRecipes(): LiveData<List<Recipe>>? {
        return try {
            getAllRecipesApi(Recipe(mealtype = randomMealType()))
            //Insertar en la base de datos
        } catch (ex: Exception) {
            ex.message?.let { logError(it) }
            null
        }
    }

    fun randomMealType() = Mealtype.values()[(Mealtype.values().indices).random()]
}