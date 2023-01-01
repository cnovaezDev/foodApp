package cnovaez.dev.foodapp.data.network

import androidx.lifecycle.LiveData
import cnovaez.dev.foodapp.domain.models.network.Recipe
import retrofit2.http.GET
import retrofit2.http.Path

/**
 ** Created by Carlos A. Novaez Guerrero on 31/12/2022 6:53
 ** cnovaez.dev@outlook.com
 **/

interface RetrofitAPI {

    @GET
    suspend fun getAllRecipesThatMatchQuery(query: String): LiveData<List<Recipe>>

    @GET("/{id}")
    fun getRecipesWithId(@Path("id") id: Int): Recipe

}