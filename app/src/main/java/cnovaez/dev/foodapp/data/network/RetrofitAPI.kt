package cnovaez.dev.foodapp.data.network

import cnovaez.dev.foodapp.utils.GlobalValues
import cnovaez.dev.foodapp.utils.data_types.CousineType
import cnovaez.dev.foodapp.utils.data_types.Mealtype
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 ** Created by Carlos A. Novaez Guerrero on 31/12/2022 6:53
 ** cnovaez.dev@outlook.com
 **/

interface RetrofitAPI {

    @GET("/api/recipes/v2")
    suspend fun getAllRecipesThatMatchQuery(
        @Query("q") query: String = "Sugar",
        @Query("mealType") mealtype: Mealtype? = null,
        @Query("cuisineType") cousineType: CousineType? = null,
        @Query("type") type: String = "public",
        @Query("app_id") appId: String = GlobalValues.appId,
        @Query("app_key") appKey: String = GlobalValues.appKey
    ): Response<*>

//    @GET("/api/recipes/v2")
//    suspend fun getAllRecipesThatMatchQueryyyyy(
//        @Query("type") type: String = "public",
//        @Query("q") query: String = "Sugar",
//        @Query("app_id") appId: String = GlobalValues.appId,
//        @Query("app_key") appKey: String = GlobalValues.appKey
//    ): retrofit2.Response

//    @GET("/{id}")
//    fun getRecipesWithId(@Path("id") id: Int): Response

}