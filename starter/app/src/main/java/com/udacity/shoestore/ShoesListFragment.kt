package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.ShoeStoreViewModel

class ShoesListFragment : Fragment() {

    lateinit var viewModel: ShoeStoreViewModel
    lateinit var binding : FragmentShoesListBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)
        viewModel = ViewModelProvider(this.activity as MainActivity).get(ShoeStoreViewModel::class.java)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToDetailsButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_shoesListFragment_to_shoeDetailsFragment)
        )

        viewModel.shoesList.observe(viewLifecycleOwner, Observer {
            if (viewModel.shoesList.value!!.size > 0) {
                val newShoe = viewModel.shoesList.value!![viewModel.shoesList.value!!.size - 1]
                val cardView = CardView(requireContext())
                val layoutParams = LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )
                layoutParams.bottomMargin = 8
                cardView.layoutParams = layoutParams
                cardView.radius = 12F
                cardView.setContentPadding(25, 25,25,25)
                cardView.elevation = 8F
                cardView.maxCardElevation = 12F
                val tv = TextView(requireContext())
                tv.text = newShoe.name + "\n" + newShoe.company + "   " + newShoe.size.toString() + "   " + newShoe.description

                cardView.addView(tv)
                binding.shoesListLayout.addView(cardView)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_shoes_list, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        if(item.itemId == R.id.logout_item) {
            this.findNavController().navigate(R.id.action_shoesListFragment_to_loginFragment)
        }
        return true
    }

}