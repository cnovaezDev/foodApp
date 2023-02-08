package cnovaez.dev.foodapp.data.repositories

import cnovaez.dev.foodapp.data.network.RetrofitAPI
import cnovaez.dev.foodapp.domain.models.network.RecipeBodyClass
import cnovaez.dev.foodapp.utils.data_types.Mealtype
import cnovaez.dev.foodapp.utils.logError
import retrofit2.Response
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 01/01/2023 12:32
 ** cnovaez.dev@outlook.com
 **/

class FoodRepository @Inject constructor(private val retrofitAPI: RetrofitAPI) {


    private suspend fun getAllRecipesApi(recipeBodyClass: RecipeBodyClass): Response<*> {
        return retrofitAPI.getAllRecipesThatMatchQuery(
            recipeBodyClass.query,
            recipeBodyClass.mealtype,
            recipeBodyClass.cousineType
        )

    }
//    private suspend fun getAllRecipesApi2(recipeBodyClass: RecipeBodyClass): retrofit2.Response<*> {
//        return retrofitAPI.getAllRecipesThatMatchQueryyyyy()
//    }

    suspend fun getRecipes(
        recipeBodyClass: RecipeBodyClass,
        forceUpdate: Boolean = false
    ): Response<*>? {
        return try {
            getAllRecipesApi(recipeBodyClass)
            //Insertar en la base de datos
        } catch (ex: Exception) {
            ex.message?.let { logError(it) }
            null
        }
    }

    suspend fun getRecipes(): Response<*>? {
        return try {
            getAllRecipesApi(RecipeBodyClass(mealtype = randomMealType()))
            //Insertar en la base de datos
        } catch (ex: Exception) {
            ex.message?.let { logError(it) }
            null
        }
    }
//    suspend fun getRecipes2(): retrofit2.Response<*>? {
//        return try {
//            getAllRecipesApi2(RecipeBodyClass(mealtype = randomMealType()))
//            //Insertar en la base de datos
//        } catch (ex: Exception) {
//            ex.message?.let { logError(it) }
//            null
//        }
//    }

    fun randomMealType() = Mealtype.values()[(Mealtype.values().indices).random()]
}