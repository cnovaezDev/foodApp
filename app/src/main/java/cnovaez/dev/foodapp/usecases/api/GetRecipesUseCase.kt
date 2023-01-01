package cnovaez.dev.foodapp.usecases.api

import cnovaez.dev.foodapp.data.repositories.FoodRepository
import cnovaez.dev.foodapp.domain.models.network.Recipe
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 01/01/2023 14:37
 ** cnovaez.dev@outlook.com
 **/
class GetRecipesUseCase @Inject constructor(val foodRepository: FoodRepository) {

    suspend operator fun invoke(recipe: Recipe) = foodRepository.getRecipes(recipe)
    suspend operator fun invoke() = foodRepository.getRecipes()

}