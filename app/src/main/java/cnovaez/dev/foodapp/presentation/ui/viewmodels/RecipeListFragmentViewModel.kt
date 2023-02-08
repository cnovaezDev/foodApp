package cnovaez.dev.foodapp.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cnovaez.dev.foodapp.domain.models.network.RecipeBodyClass
import cnovaez.dev.foodapp.domain.models.network.api_response.Recipe
import cnovaez.dev.foodapp.usecases.api.GetRecipesUseCase
import cnovaez.dev.foodapp.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 29/12/2022 16:53
 ** cnovaez.dev@outlook.com
 **/
@HiltViewModel
class RecipeListFragmentViewModel @Inject constructor(val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {

    val logOutUser: MutableLiveData<Event<Boolean>> = MutableLiveData()
    val showLoading: MutableLiveData<Boolean> = MutableLiveData()

    var recipes: MutableLiveData<List<Recipe>> = MutableLiveData()

    init {
        initialize_recipes()
    }

    fun initialize_recipes() {
        CoroutineScope(Dispatchers.IO).launch {

            val response = getRecipesUseCase.invoke()
           // val response2 = getRecipesUseCase.invoke(true)
            recipes.postValue(response)

            println("RECIPE: $response")
        }
    }

    fun SignOutUser() {
        logOutUser.value = Event(true)
    }

    fun loadRecipes(recipeBodyClass: RecipeBodyClass) {
        // CoroutineScope(Dispatchers.IO).launch { recipes.postValue(getRecipesUseCase.invoke(recipeBodyClass)?.value) }
    }

}

