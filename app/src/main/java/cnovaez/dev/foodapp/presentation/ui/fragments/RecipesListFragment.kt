package cnovaez.dev.foodapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import cnovaez.dev.foodapp.R
import cnovaez.dev.foodapp.databinding.FragmentRecipesListBinding

import cnovaez.dev.foodapp.presentation.ui.viewmodels.RecipeListFragmentViewModel
import cnovaez.dev.foodapp.utils.navigate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class RecipesListFragment : Fragment() {
    private lateinit var binding: FragmentRecipesListBinding
    private lateinit var auth: FirebaseAuth

    private val recipeListFragmentViewModel: RecipeListFragmentViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipesListBinding.inflate(inflater, container, false)


        auth = Firebase.auth
        binding.recipeViewModel = recipeListFragmentViewModel
        binding.lifecycleOwner = this

        recipeListFragmentViewModel.logOutUser.observe(viewLifecycleOwner) {
            it?.let {
                signOutUser()
            }
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser == null) {
            this.navigate(RecipesListFragmentDirections.actionRecipesListFragmentToLoginFragment())
        }
    }
    fun signOutUser() {
        Firebase.auth.signOut()
        navigate(RecipesListFragmentDirections.actionRecipesListFragmentToLoginFragment())
    }

}