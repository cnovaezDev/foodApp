package cnovaez.dev.foodapp.domain.models.network

import cnovaez.dev.foodapp.utils.GlobalValues
import cnovaez.dev.foodapp.utils.data_types.CousineType
import cnovaez.dev.foodapp.utils.data_types.Mealtype
import com.google.gson.annotations.SerializedName
import retrofit2.http.Path

/**
 ** Created by Carlos A. Novaez Guerrero on 31/12/2022 7:02
 ** cnovaez.dev@outlook.com
 **/
data class Recipe(
    @SerializedName("q") val query: String = "",
    @SerializedName("app_id") val appId: String = GlobalValues.appId,
    @SerializedName("app_key") val appKey: String = GlobalValues.appKey,
    @SerializedName("cuisineType") val cousineType: CousineType? = null,
    @SerializedName("mealType") val mealtype: Mealtype
)