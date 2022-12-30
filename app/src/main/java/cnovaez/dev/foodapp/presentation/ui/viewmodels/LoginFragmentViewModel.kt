package cnovaez.dev.foodapp.presentation.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cnovaez.dev.foodapp.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 ** Created by Carlos A. Novaez Guerrero on 29/12/2022 12:27
 ** cnovaez.dev@outlook.com
 **/
@HiltViewModel
class LoginFragmentViewModel @Inject constructor() : ViewModel() {

    val captureUserData: MutableLiveData<Boolean> = MutableLiveData()
    val captureUserDataForCreation: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToHome: MutableLiveData<Event<Boolean>> = MutableLiveData()

    val showConfirmPasswordDialoField: MutableLiveData<Boolean> = MutableLiveData()
    private var showConfirmPassField: Boolean = false;

    fun captureUserData() {
        captureUserData.value = true
    }

    fun endUserDataCapture() {
        captureUserData.value = false
    }
    fun captureUserDataForCreation() {
        captureUserDataForCreation.value = true
    }

    fun endUserDataCaptureForCreation() {
        captureUserDataForCreation.value = false
    }

    fun navigateHome() {
        navigateToHome.value = Event(true)
    }

    fun showHideConfirmPasswordField() {
        showConfirmPassField = !showConfirmPassField
        showConfirmPasswordDialoField.value = showConfirmPassField
    }
}