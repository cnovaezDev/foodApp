package cnovaez.dev.foodapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import cnovaez.dev.foodapp.R
import cnovaez.dev.foodapp.databinding.ActivityMainBinding
import cnovaez.dev.foodapp.presentation.ui.fragments.RecipesListFragmentDirections
import cnovaez.dev.foodapp.presentation.ui.viewmodels.ActivityMainViewModel
import cnovaez.dev.foodapp.utils.navigate
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val activityMainViewModel: ActivityMainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    public override fun onStart() {
        super.onStart()

    }



}