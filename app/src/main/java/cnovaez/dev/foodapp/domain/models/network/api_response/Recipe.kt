package cnovaez.dev.foodapp.domain.models.network.api_response

import com.google.gson.annotations.SerializedName

data class Recipe(

      @SerializedName("uri") var uri: String? = null,
      @SerializedName("label") var label: String? = null,
      @SerializedName("image") var image: String? = null,
      //@SerializedName("images") var images: Images? = Images(),
      @SerializedName("source") var source: String? = null,
      @SerializedName("url") var url: String? = null,
      @SerializedName("shareAs") var shareAs: String? = null,
      @SerializedName("yield") var yield: Int? = null,
      @SerializedName("dietLabels") var dietLabels: ArrayList<String> = arrayListOf(),
      @SerializedName("healthLabels") var healthLabels: ArrayList<String> = arrayListOf(),
      @SerializedName("cautions") var cautions: ArrayList<String> = arrayListOf(),
      @SerializedName("ingredientLines") var ingredientLines: ArrayList<String> = arrayListOf(),
     // @SerializedName("ingredients") var ingredients: ArrayList<Ingredients> = arrayListOf(),
      @SerializedName("calories") var calories: Int? = null,
      @SerializedName("glycemicIndex") var glycemicIndex: Int? = null,
      @SerializedName("totalCO2Emissions") var totalCO2Emissions: Int? = null,
      @SerializedName("co2EmissionsClass") var co2EmissionsClass: String? = null,
      @SerializedName("totalWeight") var totalWeight: Int? = null,
      @SerializedName("cuisineType") var cuisineType: ArrayList<String> = arrayListOf(),
      @SerializedName("mealType") var mealType: ArrayList<String> = arrayListOf(),
      @SerializedName("dishType") var dishType: ArrayList<String> = arrayListOf(),
      @SerializedName("instructions") var instructions: ArrayList<String> = arrayListOf(),
      @SerializedName("tags") var tags: ArrayList<String> = arrayListOf(),
      @SerializedName("externalId") var externalId: String? = null,
      @SerializedName("totalNutrients"    ) var totalNutrients    : Any?        = null,
      @SerializedName("totalDaily"        ) var totalDaily        : Any?            = null,
    //  @SerializedName("digest") var digest: ArrayList<Digest> = arrayListOf()

   )