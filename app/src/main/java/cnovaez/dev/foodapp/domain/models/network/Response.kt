package cnovaez.dev.foodapp.domain.models.network

import com.google.gson.annotations.SerializedName

/**
 ** Created by Carlos A. Novaez Guerrero on 02/01/2023 10:46
 ** cnovaez.dev@outlook.com
 **/
 data class Response (

    @SerializedName("from"   ) var from  : Int?            = null,
    @SerializedName("to"     ) var to    : Int?            = null,
    @SerializedName("count"  ) var count : Int?            = null,
    @SerializedName("_links" ) var links : Links?          = Links(),
    @SerializedName("hits"   ) var hits  : ArrayList<Hits> = arrayListOf()

) {


  data class Hits(

      @SerializedName("recipe") var recipe: Recipe? = Recipe(),
      @SerializedName("_links") var Links: Links? = Links()

   )

   data class Links(

      @SerializedName("self") var self: Self? = Self(),
      @SerializedName("next") var next: Next? = Next()

   )

   data class Self(

      @SerializedName("href") var href: String? = null,
      @SerializedName("title") var title: String? = null

   )


   data  class Next(

      @SerializedName("href") var href: String? = null,
      @SerializedName("title") var title: String? = null

   )

   data class Recipe(

      @SerializedName("uri") var uri: String? = null,
      @SerializedName("label") var label: String? = null,
      @SerializedName("image") var image: String? = null,
      @SerializedName("images") var images: Images? = Images(),
      @SerializedName("source") var source: String? = null,
      @SerializedName("url") var url: String? = null,
      @SerializedName("shareAs") var shareAs: String? = null,
      @SerializedName("yield") var yield: Int? = null,
      @SerializedName("dietLabels") var dietLabels: ArrayList<String> = arrayListOf(),
      @SerializedName("healthLabels") var healthLabels: ArrayList<String> = arrayListOf(),
      @SerializedName("cautions") var cautions: ArrayList<String> = arrayListOf(),
      @SerializedName("ingredientLines") var ingredientLines: ArrayList<String> = arrayListOf(),
      @SerializedName("ingredients") var ingredients: ArrayList<Ingredients> = arrayListOf(),
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
      @SerializedName("digest") var digest: ArrayList<Digest> = arrayListOf()

   )


   data class REGULAR(

      @SerializedName("url") var url: String? = null,
      @SerializedName("width") var width: Int? = null,
      @SerializedName("height") var height: Int? = null

   )

// class Sub (
//
//
//)
//
// class TotalNutrients (
//
//
//)
//
// class TotalDaily (
//
//
//)

   data  class LARGE(

      @SerializedName("url") var url: String? = null,
      @SerializedName("width") var width: Int? = null,
      @SerializedName("height") var height: Int? = null

   )

   data class SMALL(

      @SerializedName("url") var url: String? = null,
      @SerializedName("width") var width: Int? = null,
      @SerializedName("height") var height: Int? = null

   )

   data  class THUMBNAIL(

      @SerializedName("url") var url: String? = null,
      @SerializedName("width") var width: Int? = null,
      @SerializedName("height") var height: Int? = null

   )


   data class Digest(

      @SerializedName("label") var label: String? = null,
      @SerializedName("tag") var tag: String? = null,
      @SerializedName("schemaOrgTag") var schemaOrgTag: String? = null,
      @SerializedName("total") var total: Int? = null,
      @SerializedName("hasRDI") var hasRDI: Boolean? = null,
      @SerializedName("daily") var daily: Int? = null,
      @SerializedName("unit") var unit: String? = null,
        @SerializedName("sub"          ) var sub          : Any?     = null

   )

   data class Ingredients(

      @SerializedName("text") var text: String? = null,
      @SerializedName("quantity") var quantity: Int? = null,
      @SerializedName("measure") var measure: String? = null,
      @SerializedName("food") var food: String? = null,
      @SerializedName("weight") var weight: Int? = null,
      @SerializedName("foodId") var foodId: String? = null

   )


   class Images(

      @SerializedName("THUMBNAIL") var THUMBNAIL: THUMBNAIL? = THUMBNAIL(),
      @SerializedName("SMALL") var SMALL: SMALL? = SMALL(),
      @SerializedName("REGULAR") var REGULAR: REGULAR? = REGULAR(),
      @SerializedName("LARGE") var LARGE: LARGE? = LARGE()

   )

}