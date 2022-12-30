package cnovaez.dev.foodapp.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cnovaez.dev.foodapp.utils.Event

/**
 ** Created by Carlos A. Novaez Guerrero on 29/12/2022 16:53
 ** cnovaez.dev@outlook.com
 **/
class RecipeListFragmentViewModel: ViewModel() {

    val logOutUser: MutableLiveData<Event<Boolean>> = MutableLiveData()

    fun SignOutUser() {
        logOutUser.value = Event(true)
    }
}