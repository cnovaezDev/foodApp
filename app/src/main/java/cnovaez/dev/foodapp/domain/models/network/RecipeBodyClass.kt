package cnovaez.dev.foodapp.domain.models.network

import androidx.room.Query
import cnovaez.dev.foodapp.utils.GlobalValues
import cnovaez.dev.foodapp.utils.data_types.CousineType
import cnovaez.dev.foodapp.utils.data_types.Mealtype
import com.google.gson.annotations.SerializedName

/**
 ** Created by Carlos A. Novaez Guerrero on 31/12/2022 7:02
 ** cnovaez.dev@outlook.com
 **/
data class RecipeBodyClass(
    @SerializedName("q") val query: String = "Sugar",
    @SerializedName("type") val type: String = "public",
    @SerializedName("cuisineType") val cousineType: CousineType? = CousineType.American,
    @SerializedName("mealType") val mealtype: Mealtype,
    @SerializedName("app_id") val appId: String = GlobalValues.appId,
    @SerializedName("app_key") val appKey: String = GlobalValues.appKey

)