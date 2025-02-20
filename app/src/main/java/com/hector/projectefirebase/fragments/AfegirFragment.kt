package com.hector.projectefirebase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hector.projectefirebase.R
import com.hector.projectefirebase.model.Moble
import com.hector.projectefirebase.viewModel.InsertViewModel
import com.hector.projectefirebase.databinding.FragmentAfegirBinding

class AfegirFragment : Fragment() {
    private lateinit var binding: FragmentAfegirBinding
    private val viewModel: InsertViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentAfegirBinding.inflate(inflater)

        binding.BtnAfegir.setOnClickListener {
            val name = binding.NomEditarText.text.toString()
            val price = binding.PreuEditarText.text.toString().toInt()

            viewModel.insertMobles(requireContext(), Moble(null, name, price))
        }

        binding.BtnReturn.setOnClickListener {
            findNavController().navigate(R.id.action_fragmentAfegir_to_fragmentMobles, null)
        }

        return binding.root
    }
}