package com.udacity.shoestore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.FragmentShoeDetailsBinding
import com.udacity.shoestore.models.ShoeStoreViewModel

class ShoeDetailsFragment : Fragment() {

    lateinit var viewModel: ShoeStoreViewModel
    lateinit var binding : FragmentShoeDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_details, container, false)
        viewModel = ViewModelProvider(this.activity as MainActivity).get(ShoeStoreViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cancelButton.setOnClickListener {
            this.findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            viewModel.addNewShoe(
                binding.nameEditText.text.toString(),
                binding.companyEditText.text.toString(),
                binding.sizeEditText.text.toString(),
                binding.descriptionEditText.text.toString()
            )
            this.findNavController().navigateUp()
        }
    }

}