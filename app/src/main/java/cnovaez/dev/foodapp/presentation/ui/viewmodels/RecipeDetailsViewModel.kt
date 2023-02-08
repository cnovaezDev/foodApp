package cnovaez.dev.foodapp.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 27/01/2023 10:04
 ** cnovaez.dev@outlook.com
 **/

class RecipeDetailsViewModel @AssistedInject constructor(
    @Assisted
    val url: String?
) : ViewModel() {

    val urlRecipe: MutableLiveData<String?> = MutableLiveData()

    // It's a factory of this viewmodel, we need
    // to annotate this factory interface
    // with @AssistedFactory in order to
    // let Dagger-Hilt know about it
    @AssistedFactory
    interface RecipeDetailsViewModelFactory {
        fun create(url: String?): RecipeDetailsViewModel
    }

    // Suppressing unchecked cast warning
    @Suppress("UNCHECKED_CAST")
    companion object {
        // putting this function inside
        // companion object so that we can
        // access it from outside i.e. from fragment/activity
        fun providesFactory(
            assistedFactory: RecipeDetailsViewModelFactory,
            url: String?
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                // using our RecipeDetailsViewModelFactory's create function
                // to actually create our viewmodel instance
                return assistedFactory.create(url) as T
            }
        }
    }

    init {
        urlRecipe.postValue(url)
    }

}