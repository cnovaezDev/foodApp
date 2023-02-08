package cnovaez.dev.foodapp.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cnovaez.dev.foodapp.R
import cnovaez.dev.foodapp.databinding.RecipeItemLayoutBinding
import cnovaez.dev.foodapp.domain.models.network.api_response.Recipe
import cnovaez.dev.foodapp.presentation.ui.fragments.RecipesListFragmentDirections
import cnovaez.dev.foodapp.presentation.ui.fragments.RecipesListFragmentDirections.ActionRecipesListFragmentToRecipeDetailsFragment
import com.bumptech.glide.Glide

/**
 ** Created by Carlos A. Novaez Guerrero on 02/01/2023 10:13
 ** cnovaez.dev@outlook.com
 **/
class RecipesAdapter : ListAdapter<Recipe, RecipesAdapter.ViewHolder>(RecipeDiffCallback()) {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }


    class ViewHolder private constructor(val binding: RecipeItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Recipe) {
            binding.recipe = item

            Glide.with(binding.root)
                .load(item.image)
                .centerCrop()
                .thumbnail(Glide.with(binding.root).load(R.drawable.animation_loading))
                .into(binding.imageRecipeIv);

            binding.descriptionTv.text = item.ingredientLines.joinToString(limit = 4)
            binding.recipeCard.setOnClickListener {
                Navigation.findNavController(binding.root).navigate(
                    RecipesListFragmentDirections.actionRecipesListFragmentToRecipeDetailsFragment(
                        item.url
                    )
                )
            }
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = RecipeItemLayoutBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)

            }
        }
    }
}

class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
    override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
        return oldItem.equals(newItem)
    }

}