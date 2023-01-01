package cnovaez.dev.foodapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import cnovaez.dev.foodapp.databinding.FragmentLoginBinding
import cnovaez.dev.foodapp.domain.models.database.User
import cnovaez.dev.foodapp.presentation.ui.viewmodels.LoginFragmentViewModel
import cnovaez.dev.foodapp.utils.logError
import cnovaez.dev.foodapp.utils.logInformation
import cnovaez.dev.foodapp.utils.navigate
import cnovaez.dev.foodapp.utils.showToast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLoginBinding
    private lateinit var email: String
    private lateinit var password: String

    private val loginViewModel: LoginFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        initializeVariables()
        initializeObservers()


        return binding.root
    }

    private fun initializeObservers() {
        //For capturing data for login
        loginViewModel.captureUserData.observe(viewLifecycleOwner) {
            if (it) {
                loginViewModel.endUserDataCapture()
                if (!checkNoEmptyFields()) {
                    AttemptSigInUser(
                        User(
                            binding.emailLoginTiet.text.toString(),
                            binding.passwordLoginTiet.text.toString()
                        )
                    )
                }
            }
        }
        //For navigating to home
        loginViewModel.navigateToHome.observe(viewLifecycleOwner) {
            it.getContentIfNotHandled().let {
                navigate(LoginFragmentDirections.actionLoginFragmentToRecipesListFragment())
            }

        }
        //For showing/hiding the ConfirmPasswordField
        loginViewModel.showConfirmPasswordDialoField.observe(viewLifecycleOwner) {
            if (it) {
                binding.passwordConfirmLoginTil.visibility = View.VISIBLE
                binding.loginBtn.visibility = View.GONE
                binding.createUserBtn.visibility = View.VISIBLE

            } else {
                binding.passwordConfirmLoginTil.visibility = View.GONE
                binding.loginBtn.visibility = View.VISIBLE
                binding.createUserBtn.visibility = View.GONE
            }
        }
        //For capturing the data for creating a new user
        loginViewModel.captureUserDataForCreation.observe(viewLifecycleOwner) {
            it?.let {
                if (it) {
                    if (!checkNoEmptyFields(true) && !checkPasswordFieldsMatch()) {
                        createNewUser(
                            User(
                                binding.emailLoginTiet.text.toString(),
                                binding.passwordLoginTiet.text.toString()
                            )
                        )
                    }
                }
            }
        }
    }

    private fun checkNoEmptyFields(includeConfirmPassField: Boolean = false): Boolean {
        var error = false
        if (binding.emailLoginTiet.text.toString().isEmpty()) {
            binding.emailLoginTil.error = "Field can't be empty"
            error = true
        } else binding.emailLoginTil.error = null

        if (binding.passwordLoginTiet.text.toString().isEmpty()) {
            binding.passwordLoginTil.error = "Field can't be empty"
            error = true
        } else binding.passwordLoginTil.error = null
        if (includeConfirmPassField) {
            if (binding.passwordConfirmLoginTiet.text.toString().isEmpty()) {
                binding.passwordConfirmLoginTil.error = "Field can't be empty"
                error = true
            } else binding.passwordConfirmLoginTil.error = null
        }
        return error
    }

    private fun checkPasswordFieldsMatch(): Boolean {
        var error = false
        if (!binding.passwordLoginTiet.text.toString()
                .equals(binding.passwordConfirmLoginTiet.text.toString())
        ) {
            binding.passwordLoginTil.error = "Passwords fields must match"
            binding.passwordConfirmLoginTil.error = "Passwords fields must match"
            error = true
        }
        return error
    }

    private fun initializeVariables() {
        auth = Firebase.auth

        binding.loginViewModel = loginViewModel
        binding.lifecycleOwner = viewLifecycleOwner
    }

    fun createNewUser(user: User) {
        auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    logInformation("createUserWithEmail:success")
                    val userConnected = auth.currentUser
                    // updateUI(user)
                    showToast(
                        requireContext(),
                        "User ${userConnected?.displayName} created successfully"
                    )

                    loginViewModel.endUserDataCaptureForCreation()

                } else {
                    // If sign in fails, display a message to the user.
                    logError("createUserWithEmail:failure:  ${task.exception}")
                    showToast(
                        requireContext(),
                        "User creation failed: ${task.exception}",
                        Toast.LENGTH_LONG
                    )
                }
            }
    }

    fun AttemptSigInUser(user: User) {
        auth.signInWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    logInformation("signInWithEmail:success")
                    val user = auth.currentUser
                    loginViewModel.navigateHome()
                    //  updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    logError("signInWithEmail:failure: ${task.exception}")
                    Toast.makeText(
                        requireContext(), "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }

    override fun onResume() {
        super.onResume()

    }

    fun signOutUser() {
        Firebase.auth.signOut()
    }


}