package cnovaez.dev.foodapp.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import cnovaez.dev.foodapp.R
import cnovaez.dev.foodapp.databinding.FragmentRecipeDetailsBinding
import cnovaez.dev.foodapp.presentation.ui.viewmodels.RecipeDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class RecipeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentRecipeDetailsBinding


    // Using navargs for getting argument
    // supplied from previous fragment
    private val args: RecipeDetailsFragmentArgs by navArgs()


    // First injecting our
    // viewmodel's factory interface
    @Inject
    lateinit var recipeDetailsViewModelFactory: RecipeDetailsViewModel.RecipeDetailsViewModelFactory

    private val recipeDetailsViewModel: RecipeDetailsViewModel by viewModels {
        RecipeDetailsViewModel.providesFactory(
            assistedFactory = recipeDetailsViewModelFactory,
            url = args.url
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRecipeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recipeDetailsViewModel.urlRecipe.observe(viewLifecycleOwner){
            it.let { urlRecipe ->
                binding.webviewRecipe.loadUrl(urlRecipe!!)
            }
        }
    }

}