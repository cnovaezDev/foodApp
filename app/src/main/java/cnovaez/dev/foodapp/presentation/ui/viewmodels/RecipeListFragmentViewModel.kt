package cnovaez.dev.foodapp.presentation.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cnovaez.dev.foodapp.domain.models.network.Recipe
import cnovaez.dev.foodapp.usecases.api.GetRecipesUseCase
import cnovaez.dev.foodapp.utils.Event
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 29/12/2022 16:53
 ** cnovaez.dev@outlook.com
 **/
class RecipeListFragmentViewModel @Inject constructor(val getRecipesUseCase: GetRecipesUseCase) :
    ViewModel() {

    val logOutUser: MutableLiveData<Event<Boolean>> = MutableLiveData()
    val showLoading: MutableLiveData<Boolean> = MutableLiveData()

    lateinit var recipes: MutableLiveData<List<Recipe>>

    init {
        CoroutineScope(Dispatchers.IO).launch { getRecipesUseCase.invoke() as MutableLiveData}
    }

    fun SignOutUser() {
        logOutUser.value = Event(true)
    }

    fun loadRecipes(recipe: Recipe) {
        CoroutineScope(Dispatchers.IO).launch { recipes.postValue(getRecipesUseCase.invoke(recipe)?.value) }
    }

}

